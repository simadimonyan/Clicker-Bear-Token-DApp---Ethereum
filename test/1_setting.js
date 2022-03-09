const wallet = artifacts.require("MultiSigBearWallet");
const channel = artifacts.require("PaymentChannel");
const token = artifacts.require("Token");
let owners = ['0x29b565535918d954f7a1d6c5525d5c8b022f4f0b', '0xbddef9f6288b774ffdc41becd0296f70e9c518bd'];

contract("Multi Signature Wallet", accounts => {
  it("Test 1 - Checking Owners...", async () => {
    let instance = await wallet.deployed();
    let getOwners = await instance.getOwners();
    for (let i = 0; i < owners.length; i++) {
      assert.equal(getOwners[i].toLowerCase(), owners[i]);
    };
  });
});

contract("Payment Channel", accounts => {
  it("Test 1 - Checking Owner...", async () => {
    let instance = await channel.deployed();
    let owner = await instance.owner;
    let walletAddress = await wallet.deployed().address;
    assert.equal(owner, walletAddress);
  });
  it("Test 2 - Setting Validators From Wallet...", async () => {
    let channelInstance = await channel.deployed();
    let walletInstance = await wallet.deployed();
    // signing
    let signature = await web3.eth.abi.encodeFunctionCall({
      name: 'replaceValidators',
      type: 'function',
      inputs: [{
        type: 'address[]',
        name: 'validators'
      }]
    }, [owners], {from: accounts[0]});
    // submitting
    await walletInstance.submitTransaction(channelInstance.address, 0, signature,
       {from: accounts[0]});
    // confirming
    await walletInstance.confirmTransaction(await walletInstance
      .getTransactionCount() - 1, {from: accounts[0]});
    await walletInstance.confirmTransaction(await walletInstance
      .getTransactionCount() - 1, {from: accounts[1]});
    // executing
    await walletInstance.executeTransaction(await walletInstance
      .getTransactionCount() - 1, {from: accounts[0]});
  });
  it("Test 3 - Checking Validators...", async () => {
    let instance = await channel.deployed();
    let getValidators = await instance.getValidators();
    for (let i = 0; i < owners.length; i++) {
      assert.equal(owners[i], getValidators[i].toLowerCase());
    }
  });
  it("Test 4 - Setting ERC20 Token...", async () => {
    let channelInstance = await channel.deployed();
    let walletInstance = await wallet.deployed();
    let tokenInstance = await token.deployed();
    // signing
    let signature = web3.eth.abi.encodeFunctionCall({
      name: 'connectToken',
      type: 'function',
      inputs: [{
        type: 'address',
        name: 'token'
      }]
    }, [tokenInstance.address], {from: accounts[0]});
    // submitting
    await walletInstance.submitTransaction(channelInstance.address, 0, signature,
       {from: accounts[0]});
    // confirming
    await walletInstance.confirmTransaction(await walletInstance
      .getTransactionCount() - 1, {from: accounts[0]});
    await walletInstance.confirmTransaction(await walletInstance
      .getTransactionCount() - 1, {from: accounts[1]});
    // executing
    await walletInstance.executeTransaction(await walletInstance
      .getTransactionCount() - 1, {from: accounts[0]});
  });
  it("Test 5 - Checking ERC20 Connection...", async () => {
    let tokenInstance = await token.deployed().address;
    let tokenAddress = await channel.deployed().connectToken;
    assert.equal(tokenInstance, tokenAddress);
  });
});
