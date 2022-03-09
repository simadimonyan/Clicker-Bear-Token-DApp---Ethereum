const wallet = artifacts.require("MultiSigBearWallet");
const channel = artifacts.require("PaymentChannel");
const token = artifacts.require("Token");
let claimer = '0x9e9010e2509be8bae727d9ead847530d79966168';
let key = '0x35e519865ff4d091bfb45629aa80d00f58483c1d82d1e1b4ca5ebf20827e6f19'
let owners = ['0x29b565535918d954f7a1d6c5525d5c8b022f4f0b', '0xbddef9f6288b774ffdc41becd0296f70e9c518bd'];

contract("Payment Channel", accounts => {
  it("Test 1 - Claiming Payment", async () => {
    // setting Validators
    let channelInstance = await channel.deployed();
    let walletInstance = await wallet.deployed();
    let tokenInstance = await token.deployed();
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

    // signing
    let signature2 = web3.eth.abi.encodeFunctionCall({
        name: 'connectToken',
        type: 'function',
        inputs: [{
          type: 'address',
          name: 'token'
        }]
    }, [tokenInstance.address], {from: accounts[0]});
    // submitting
    await walletInstance.submitTransaction(channelInstance.address, 0, signature2,
         {from: accounts[0]});
    // confirming
    await walletInstance.confirmTransaction(await walletInstance
        .getTransactionCount() - 1, {from: accounts[0]});
    await walletInstance.confirmTransaction(await walletInstance
        .getTransactionCount() - 1, {from: accounts[1]});
    // executing
    await walletInstance.executeTransaction(await walletInstance
        .getTransactionCount() - 1, {from: accounts[0]});

    // dApp interactions
    let encrypt = await web3.utils.soliditySha3(claimer, 1000000, 1);
    console.log(encrypt);
    let prefixed = await web3.utils.soliditySha3("\x19Ethereum Signed Message:\n32", encrypt);
    console.log(prefixed);
    let test = await channelInstance.getEthSignedHash(encrypt);
    console.log(test);
    let sig = await web3.eth.accounts.sign(encrypt, key, {from: accounts[0]})['signature'];
    console.log(await channelInstance.validate(prefixed, sig));
    // withdrawal
    await channelInstance.claimPayment(claimer, 1000000, 1, sig).then(function(tx) {
      console.log(tx);
    });
    let balance = await tokenInstance.balanceOf(claimer).then(function(balance){
      console.log(web3.utils.fromWei(balance.toString()));
    });

  });
});
