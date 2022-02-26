const wallet = artifacts.require("MultiSigBearWallet");
const channel = artifacts.require("PaymentChannel");
const token = artifacts.require("Token");
let owners = ['0x29b565535918d954f7a1d6c5525d5c8b022f4f0b', '0xbddef9f6288b774ffdc41becd0296f70e9c518bd'];
let multiSigWalletAddress;
let channelAddress;

module.exports = function (deployer) {
  deployer.deploy(wallet,
    owners,
    2).then( async () => {
      multiSigWalletAddress = wallet.address;
      console.log(multiSigWalletAddress);
    }).then( async () => {
      await deployer.deploy(channel,
        multiSigWalletAddress);
    }).then( async () => {
      channelAddress = channel.address;
      console.log(channelAddress);
    }).then( async () => {
      await deployer.deploy(token,
        multiSigWalletAddress,
        channelAddress,
        owners);
    });
};
