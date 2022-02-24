const wallet = artifacts.require("MultiSigBearWallet");
const channel = artifacts.require("PaymentChannel");
const token = artifacts.require("Token");
let owners = ['0xC2E06Dd93a8edA1c363C5656b85f2dB52c7eB927', '0x9e2addbfC16eEB1F7e46A38580e7bC05fA38CeD4'];
let multiSigWalletAddress = "0x424dABAd4ad8dE3C6d7B1CC9Aa3d88a152ff1b3C";
let channelAddress = "0x3d50d99F93e7e7d28778F78ab4763d6955048ceB";

module.exports = function (deployer) {
  // deployer.deploy(wallet,
  //   owners,
  //   2);
  // deployer.deploy(channel,
  //   multiSigWalletAddress);
  // deployer.deploy(token,
  //   multiSigWalletAddress,
  //   channelAddress,
  //   owners);
};
