package java.contracts.wrappers;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class BearWallet_sol_MultiSigBearWallet extends Contract {
    public static final String BINARY = "60806040523480156200001157600080fd5b50604051620021ec380380620021ec83398101604081905262000034916200029e565b60008251116200008b5760405162461bcd60e51b815260206004820152601460248201527f4e554c4c5f4f574e4552535f50524f564944454400000000000000000000000060448201526064015b60405180910390fd5b6000811180156200009d575081518111155b620000eb5760405162461bcd60e51b815260206004820152601c60248201527f494e56414c49445f434f4e4649524d4154494f4e535f4e554d42455200000000604482015260640162000082565b60005b8251811015620002605760008382815181106200010f576200010f62000378565b6020026020010151905060006001600160a01b0316816001600160a01b031614156200017e5760405162461bcd60e51b815260206004820152601660248201527f494e56414c49445f4f574e45525f50524f564944454400000000000000000000604482015260640162000082565b6001600160a01b03811660009081526003602052604090205460ff1615620001e95760405162461bcd60e51b815260206004820152601960248201527f4e4f545f554e495155455f4f574e45525f50524f564944454400000000000000604482015260640162000082565b6001600160a01b03166000818152600360205260408120805460ff19166001908117909155815490810182559080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5630180546001600160a01b03191690911790558062000257816200038e565b915050620000ee565b5060055550620003b8565b634e487b7160e01b600052604160045260246000fd5b80516001600160a01b03811681146200029957600080fd5b919050565b60008060408385031215620002b257600080fd5b82516001600160401b0380821115620002ca57600080fd5b818501915085601f830112620002df57600080fd5b8151602082821115620002f657620002f66200026b565b8160051b604051601f19603f830116810181811086821117156200031e576200031e6200026b565b6040529283528183019350848101820192898411156200033d57600080fd5b948201945b838610156200036657620003568662000281565b8552948201949382019362000342565b97909101519698969750505050505050565b634e487b7160e01b600052603260045260246000fd5b6000600019821415620003b157634e487b7160e01b600052601160045260246000fd5b5060010190565b611e2480620003c86000396000f3fe6080604052600436106101185760003560e01c806380f59a65116100a0578063c642747411610064578063c6427474146103b8578063e3ba6529146103d8578063e8b2c243146103f8578063e8c571d81461040e578063ee22610b1461042e57600080fd5b806380f59a65146102dd5780639ace38c214610318578063a0e67e2b14610338578063a7bb58031461035a578063c01a8c841461039857600080fd5b80632f4ea5ea116100e75780632f4ea5ea146101fc5780632f54bf6e1461021c57806333ea3dc81461025c5780636717e41c1461028d5780637065cb48146102bd57600080fd5b8063025e7c271461015e57806320ea8d861461019b578063258ae582146101bd5780632e7700f0146101dd57600080fd5b36610159576040805134815247602082015233917f90890809c654f11d6e72a28fa60149770a0d11ec6c92319d6ceb2bb0a4ea1a15910160405180910390a2005b600080fd5b34801561016a57600080fd5b5061017e6101793660046116fe565b61044e565b6040516001600160a01b0390911681526020015b60405180910390f35b3480156101a757600080fd5b506101bb6101b63660046116fe565b610478565b005b3480156101c957600080fd5b5061017e6101d83660046117ce565b610610565b3480156101e957600080fd5b506001545b604051908152602001610192565b34801561020857600080fd5b506101ee6102173660046116fe565b610690565b34801561022857600080fd5b5061024c610237366004611831565b60036020526000908152604090205460ff1681565b6040519015158152602001610192565b34801561026857600080fd5b5061027c6102773660046116fe565b6106e3565b6040516101929594939291906118a0565b34801561029957600080fd5b5061024c6102a83660046116fe565b60026020526000908152604090205460ff1681565b3480156102c957600080fd5b506101bb6102d8366004611831565b6107de565b3480156102e957600080fd5b5061024c6102f83660046118db565b600460209081526000928352604080842090915290825290205460ff1681565b34801561032457600080fd5b5061027c6103333660046116fe565b6108fe565b34801561034457600080fd5b5061034d6109d7565b6040516101929190611907565b34801561036657600080fd5b5061037a610375366004611954565b610a39565b60408051938452602084019290925260ff1690820152606001610192565b3480156103a457600080fd5b506101bb6103b33660046116fe565b610aab565b3480156103c457600080fd5b506101bb6103d3366004611991565b610c42565b3480156103e457600080fd5b506101bb6103f3366004611a9c565b610dc8565b34801561040457600080fd5b506101ee60055481565b34801561041a57600080fd5b506101bb610429366004611a9c565b6110cc565b34801561043a57600080fd5b506101bb6104493660046116fe565b6113dd565b6000818154811061045e57600080fd5b6000918252602090912001546001600160a01b0316905081565b3360009081526003602052604090205460ff166104b05760405162461bcd60e51b81526004016104a790611b5d565b60405180910390fd5b600154819081106104d35760405162461bcd60e51b81526004016104a790611b8a565b81600181815481106104e7576104e7611bc1565b600091825260209091206003600590920201015460ff161561051b5760405162461bcd60e51b81526004016104a790611bd7565b60006001848154811061053057610530611bc1565b600091825260208083208784526004825260408085203386529092529220546005909102909101915060ff166105a85760405162461bcd60e51b815260206004820152601c60248201527f5452414e53414354494f4e5f49535f4e4f545f434f4e4649524d45440000000060448201526064016104a7565b60018160040160008282546105bd9190611c24565b90915550506000848152600460209081526040808320338085529252808320805460ff191690555186927ff0dca620e2e81f7841d07bcc105e1704fb01475b278a9d4c236e1c62945edd5591a350505050565b60008060008061061f85610a39565b6040805160008152602081018083528b905260ff8316918101919091526060810184905260808101839052929550909350915060019060a0016020604051602081039080840390855afa15801561067a573d6000803e3d6000fd5b5050506020604051035193505050505b92915050565b6040517f19457468657265756d205369676e6564204d6573736167653a0a3332000000006020820152603c8101829052600090605c01604051602081830303815290604052805190602001209050919050565b600080606060008060006001878154811061070057610700611bc1565b6000918252602090912060059091020180546001820154600383015460048401546002850180549596506001600160a01b039094169492939260ff90921691839061074a90611c3b565b80601f016020809104026020016040519081016040528092919081815260200182805461077690611c3b565b80156107c35780601f10610798576101008083540402835291602001916107c3565b820191906000526020600020905b8154815290600101906020018083116107a657829003601f168201915b50505050509250955095509550955095505091939590929450565b3360009081526003602052604090205460ff1661080d5760405162461bcd60e51b81526004016104a790611b5d565b6001600160a01b038116600090815260036020526040902054819060ff16156108745760405162461bcd60e51b815260206004820152601960248201527813d395d15497d254d7d053149150511657d054141493d59151603a1b60448201526064016104a7565b600080546001810182557f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5630180546001600160a01b0319166001600160a01b03851690811790915580825260036020526040808320805460ff1916905551909133917f1c9cda327f9c5e340bd9c973d4bf53305463d512627c12a685081a57f7828f7a9190a35050565b6001818154811061090e57600080fd5b60009182526020909120600590910201805460018201546002830180546001600160a01b03909316945090929161094490611c3b565b80601f016020809104026020016040519081016040528092919081815260200182805461097090611c3b565b80156109bd5780601f10610992576101008083540402835291602001916109bd565b820191906000526020600020905b8154815290600101906020018083116109a057829003601f168201915b505050506003830154600490930154919260ff1691905085565b60606000805480602002602001604051908101604052809291908181526020018280548015610a2f57602002820191906000526020600020905b81546001600160a01b03168152600190910190602001808311610a11575b5050505050905090565b60008060008351604114610a8f5760405162461bcd60e51b815260206004820152601860248201527f494e56414c49445f5349474e41545552455f4c454e475448000000000000000060448201526064016104a7565b50505060208101516040820151606083015160001a9193909250565b3360009081526003602052604090205460ff16610ada5760405162461bcd60e51b81526004016104a790611b5d565b60015481908110610afd5760405162461bcd60e51b81526004016104a790611b8a565b8160018181548110610b1157610b11611bc1565b600091825260209091206003600590920201015460ff1615610b455760405162461bcd60e51b81526004016104a790611bd7565b6000838152600460209081526040808320338452909152902054839060ff1615610bb15760405162461bcd60e51b815260206004820181905260248201527f5452414e53414354494f4e5f49535f414c52454144595f434f4e4649524d454460448201526064016104a7565b600060018581548110610bc657610bc6611bc1565b906000526020600020906005020190506001816004016000828254610beb9190611c76565b90915550506000858152600460209081526040808320338085529252808320805460ff191660011790555187927f5cbe105e36805f7820e291f799d5794ff948af2a5f664e580382defb6339004191a35050505050565b3360009081526003602052604090205460ff16610c715760405162461bcd60e51b81526004016104a790611b5d565b600180546040805160a0810182526001600160a01b03878116825260208083018881529383018781526000606085018190526080850181905286880188559690965282517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf66005870290810180546001600160a01b0319169290941691909117835593517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf785015594518051949592949193610d54937fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf890910192910190611665565b50606082015160038201805460ff19169115159190911790556080909101516004909101556040516001600160a01b03851690829033907fd5a05bf70715ad82a09a756320284a1b54c9ff74cd0f8cce6219e79b563fe59d90610dba9088908890611c8e565b60405180910390a450505050565b3360009081526003602052604090205460ff16610df75760405162461bcd60e51b81526004016104a790611b5d565b6001600160a01b038316610e455760405162461bcd60e51b8152602060048201526015602482015274494e56414c49445f4f574e45525f4144445245535360581b60448201526064016104a7565b8051825114610e665760405162461bcd60e51b81526004016104a790611ca7565b60055481511015610e895760405162461bcd60e51b81526004016104a790611cf2565b60005b8251811015610f665760026000848381518110610eab57610eab611bc1565b60209081029190910181015182528101919091526040016000205460ff1615610f0e5760405162461bcd60e51b81526020600482015260156024820152741393d390d157d254d7d053149150511657d554d151605a1b60448201526064016104a7565b600160026000858481518110610f2657610f26611bc1565b6020026020010151815260200190815260200160002060006101000a81548160ff0219169083151502179055508080610f5e90611d37565b915050610e8c565b5060005b825181101561107f5760005b825181101561106c576000610fe886868581518110610f9757610f97611bc1565b6020026020010151604051602001610fcd92919060609290921b6bffffffffffffffffffffffff19168252601482015260340190565b60405160208183030381529060405280519060200120610690565b905061100d8185848151811061100057611000611bc1565b60200260200101516115ef565b6110595760405162461bcd60e51b815260206004820181905260248201527f4449474954414c5f5349474e41545552455f49535f4e4f545f47454e55494e4560448201526064016104a7565b508061106481611d37565b915050610f76565b508061107781611d37565b915050610f6a565b506001600160a01b038316600081815260036020526040808220805460ff191690555133917f0a9920843f89ec43b459df847863115220245568c104285bed68761cab929eef91a3505050565b3360009081526003602052604090205460ff166110fb5760405162461bcd60e51b81526004016104a790611b5d565b6001600160a01b038316600090815260036020526040902054839060ff16156111625760405162461bcd60e51b815260206004820152601960248201527813d395d15497d254d7d053149150511657d054141493d59151603a1b60448201526064016104a7565b6001600160a01b0384166111b05760405162461bcd60e51b8152602060048201526015602482015274494e56414c49445f4f574e45525f4144445245535360581b60448201526064016104a7565b81518351146111d15760405162461bcd60e51b81526004016104a790611ca7565b600554825110156111f45760405162461bcd60e51b81526004016104a790611cf2565b60005b83518110156112d1576002600085838151811061121657611216611bc1565b60209081029190910181015182528101919091526040016000205460ff16156112795760405162461bcd60e51b81526020600482015260156024820152741393d390d157d254d7d053149150511657d554d151605a1b60448201526064016104a7565b60016002600086848151811061129157611291611bc1565b6020026020010151815260200190815260200160002060006101000a81548160ff02191690831515021790555080806112c990611d37565b9150506111f7565b5060005b835181101561138c5760005b835181101561137957600061130287878581518110610f9757610f97611bc1565b905061131a8186848151811061100057611000611bc1565b6113665760405162461bcd60e51b815260206004820181905260248201527f4449474954414c5f5349474e41545552455f49535f4e4f545f47454e55494e4560448201526064016104a7565b508061137181611d37565b9150506112e1565b508061138481611d37565b9150506112d5565b506001600160a01b038416600081815260036020526040808220805460ff191660011790555133917fd313a25c355bb3218db01b84b6e4337106b73f0f9f3b71ddb02769247d8b7f2591a350505050565b3360009081526003602052604090205460ff1661140c5760405162461bcd60e51b81526004016104a790611b5d565b6001548190811061142f5760405162461bcd60e51b81526004016104a790611b8a565b816001818154811061144357611443611bc1565b600091825260209091206003600590920201015460ff16156114775760405162461bcd60e51b81526004016104a790611bd7565b60006001848154811061148c5761148c611bc1565b90600052602060002090600502019050600554816004015410156114fc5760405162461bcd60e51b815260206004820152602160248201527f494e53554646494349454e545f434f4e4649524d4154494f4e535f414d4f554e6044820152601560fa1b60648201526084016104a7565b60038101805460ff191660019081179091558154908201546040516000926001600160a01b03169190611533906002860190611d52565b60006040518083038185875af1925050503d8060008114611570576040519150601f19603f3d011682016040523d82523d6000602084013e611575565b606091505b50509050806115bb5760405162461bcd60e51b81526020600482015260126024820152711514905394d050d51253d397d1905253115160721b60448201526064016104a7565b604051859033907f5445f318f4f5fcfb66592e68e0cc5822aa15664039bd5f0ffde24c5a8142b1ac90600090a35050505050565b6000806115fc8484610610565b905060005b60005481101561165a576000818154811061161e5761161e611bc1565b6000918252602090912001546001600160a01b03838116911614156116485760019250505061068a565b8061165281611d37565b915050611601565b506000949350505050565b82805461167190611c3b565b90600052602060002090601f01602090048101928261169357600085556116d9565b82601f106116ac57805160ff19168380011785556116d9565b828001600101855582156116d9579182015b828111156116d95782518255916020019190600101906116be565b506116e59291506116e9565b5090565b5b808211156116e557600081556001016116ea565b60006020828403121561171057600080fd5b5035919050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff8111828210171561175657611756611717565b604052919050565b600082601f83011261176f57600080fd5b813567ffffffffffffffff81111561178957611789611717565b61179c601f8201601f191660200161172d565b8181528460208386010111156117b157600080fd5b816020850160208301376000918101602001919091529392505050565b600080604083850312156117e157600080fd5b82359150602083013567ffffffffffffffff8111156117ff57600080fd5b61180b8582860161175e565b9150509250929050565b80356001600160a01b038116811461182c57600080fd5b919050565b60006020828403121561184357600080fd5b61184c82611815565b9392505050565b6000815180845260005b818110156118795760208185018101518683018201520161185d565b8181111561188b576000602083870101525b50601f01601f19169290920160200192915050565b60018060a01b038616815284602082015260a0604082015260006118c760a0830186611853565b931515606083015250608001529392505050565b600080604083850312156118ee57600080fd5b823591506118fe60208401611815565b90509250929050565b6020808252825182820181905260009190848201906040850190845b818110156119485783516001600160a01b031683529284019291840191600101611923565b50909695505050505050565b60006020828403121561196657600080fd5b813567ffffffffffffffff81111561197d57600080fd5b6119898482850161175e565b949350505050565b6000806000606084860312156119a657600080fd5b6119af84611815565b925060208401359150604084013567ffffffffffffffff8111156119d257600080fd5b6119de8682870161175e565b9150509250925092565b600067ffffffffffffffff821115611a0257611a02611717565b5060051b60200190565b600082601f830112611a1d57600080fd5b81356020611a32611a2d836119e8565b61172d565b82815260059290921b84018101918181019086841115611a5157600080fd5b8286015b84811015611a9157803567ffffffffffffffff811115611a755760008081fd5b611a838986838b010161175e565b845250918301918301611a55565b509695505050505050565b600080600060608486031215611ab157600080fd5b611aba84611815565b925060208085013567ffffffffffffffff80821115611ad857600080fd5b818701915087601f830112611aec57600080fd5b8135611afa611a2d826119e8565b81815260059190911b8301840190848101908a831115611b1957600080fd5b938501935b82851015611b3757843582529385019390850190611b1e565b965050506040870135925080831115611b4f57600080fd5b50506119de86828701611a0c565b60208082526013908201527229a2a72222a92fa4a9afa727aa2fa7aba722a960691b604082015260600190565b6020808252601a908201527f5452414e53414354494f4e5f444f45535f4e4f545f4558495354000000000000604082015260600190565b634e487b7160e01b600052603260045260246000fd5b6020808252601f908201527f5452414e53414354494f4e5f49535f414c52454144595f455845435554454400604082015260600190565b634e487b7160e01b600052601160045260246000fd5b600082821015611c3657611c36611c0e565b500390565b600181811c90821680611c4f57607f821691505b60208210811415611c7057634e487b7160e01b600052602260045260246000fd5b50919050565b60008219821115611c8957611c89611c0e565b500190565b8281526040602082015260006119896040830184611853565b6020808252602b908201527f4e4f4e4345535f4152455f4e4f545f434f52524553504f4e44494e475f54484560408201526a5f5349474e41545552455360a81b606082015260800190565b60208082526025908201527f554e53554646494349454e545f5349474e4154555245535f434f4e4649524d4160408201526454494f4e5360d81b606082015260800190565b6000600019821415611d4b57611d4b611c0e565b5060010190565b600080835481600182811c915080831680611d6e57607f831692505b6020808410821415611d8e57634e487b7160e01b86526022600452602486fd5b818015611da25760018114611db357611de0565b60ff19861689528489019650611de0565b60008a81526020902060005b86811015611dd85781548b820152908501908301611dbf565b505084890196505b50949897505050505050505056fea2646970667358221220bcb975525ad50bf39baf1da7c7ee3855311a166b4f77f85db6fe6cbbc2ff773064736f6c634300080b0033";

    public static final String FUNC_ADDOWNER = "addOwner";

    public static final String FUNC_APPROVEOWNER = "approveOwner";

    public static final String FUNC_CONFIRMTRANSACTION = "confirmTransaction";

    public static final String FUNC_CONFIRMATIONSREQUIRED = "confirmationsRequired";

    public static final String FUNC_DISACTIVATEOWNER = "disactivateOwner";

    public static final String FUNC_EXECUTETRANSACTION = "executeTransaction";

    public static final String FUNC_GETETHSIGNEDHASH = "getEthSignedHash";

    public static final String FUNC_GETOWNERS = "getOwners";

    public static final String FUNC_GETTRANSACTION = "getTransaction";

    public static final String FUNC_GETTRANSACTIONCOUNT = "getTransactionCount";

    public static final String FUNC_ISCONFIRMED = "isConfirmed";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_OWNERS = "owners";

    public static final String FUNC_REVOKECONFIRMATION = "revokeConfirmation";

    public static final String FUNC_SPLITSIGNATURE = "splitSignature";

    public static final String FUNC_SUBMITTRANSACTION = "submitTransaction";

    public static final String FUNC_TRANSACTIONS = "transactions";

    public static final String FUNC_USEDNONCES = "usedNonces";

    public static final String FUNC_VERIFY = "verify";

    public static final Event CONFIRMTRANSACTION_EVENT = new Event("ConfirmTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event DEPOSIT_EVENT = new Event("Deposit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event EXECUTETRANSACTION_EVENT = new Event("ExecuteTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event OWNERADDITION_EVENT = new Event("OwnerAddition", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERAPPROVAL_EVENT = new Event("OwnerApproval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event OWNERDISACTIVATION_EVENT = new Event("OwnerDisactivation", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event REVOKECONFIRMATION_EVENT = new Event("RevokeConfirmation", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}));
    ;

    public static final Event SUBMITTRANSACTION_EVENT = new Event("SubmitTransaction", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}));
    ;

    @Deprecated
    protected BearWallet_sol_MultiSigBearWallet(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected BearWallet_sol_MultiSigBearWallet(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected BearWallet_sol_MultiSigBearWallet(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected BearWallet_sol_MultiSigBearWallet(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ConfirmTransactionEventResponse> getConfirmTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONFIRMTRANSACTION_EVENT, transactionReceipt);
        ArrayList<ConfirmTransactionEventResponse> responses = new ArrayList<ConfirmTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ConfirmTransactionEventResponse typedResponse = new ConfirmTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ConfirmTransactionEventResponse> confirmTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ConfirmTransactionEventResponse>() {
            @Override
            public ConfirmTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONFIRMTRANSACTION_EVENT, log);
                ConfirmTransactionEventResponse typedResponse = new ConfirmTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ConfirmTransactionEventResponse> confirmTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONFIRMTRANSACTION_EVENT));
        return confirmTransactionEventFlowable(filter);
    }

    public List<DepositEventResponse> getDepositEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEPOSIT_EVENT, transactionReceipt);
        ArrayList<DepositEventResponse> responses = new ArrayList<DepositEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositEventResponse typedResponse = new DepositEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DepositEventResponse> depositEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, DepositEventResponse>() {
            @Override
            public DepositEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSIT_EVENT, log);
                DepositEventResponse typedResponse = new DepositEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DepositEventResponse> depositEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSIT_EVENT));
        return depositEventFlowable(filter);
    }

    public List<ExecuteTransactionEventResponse> getExecuteTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EXECUTETRANSACTION_EVENT, transactionReceipt);
        ArrayList<ExecuteTransactionEventResponse> responses = new ArrayList<ExecuteTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ExecuteTransactionEventResponse typedResponse = new ExecuteTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ExecuteTransactionEventResponse> executeTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ExecuteTransactionEventResponse>() {
            @Override
            public ExecuteTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EXECUTETRANSACTION_EVENT, log);
                ExecuteTransactionEventResponse typedResponse = new ExecuteTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ExecuteTransactionEventResponse> executeTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EXECUTETRANSACTION_EVENT));
        return executeTransactionEventFlowable(filter);
    }

    public List<OwnerAdditionEventResponse> getOwnerAdditionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERADDITION_EVENT, transactionReceipt);
        ArrayList<OwnerAdditionEventResponse> responses = new ArrayList<OwnerAdditionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnerAdditionEventResponse typedResponse = new OwnerAdditionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnerAdditionEventResponse> ownerAdditionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnerAdditionEventResponse>() {
            @Override
            public OwnerAdditionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERADDITION_EVENT, log);
                OwnerAdditionEventResponse typedResponse = new OwnerAdditionEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnerAdditionEventResponse> ownerAdditionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERADDITION_EVENT));
        return ownerAdditionEventFlowable(filter);
    }

    public List<OwnerApprovalEventResponse> getOwnerApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERAPPROVAL_EVENT, transactionReceipt);
        ArrayList<OwnerApprovalEventResponse> responses = new ArrayList<OwnerApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnerApprovalEventResponse typedResponse = new OwnerApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.approvedOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnerApprovalEventResponse> ownerApprovalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnerApprovalEventResponse>() {
            @Override
            public OwnerApprovalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERAPPROVAL_EVENT, log);
                OwnerApprovalEventResponse typedResponse = new OwnerApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.approvedOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnerApprovalEventResponse> ownerApprovalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERAPPROVAL_EVENT));
        return ownerApprovalEventFlowable(filter);
    }

    public List<OwnerDisactivationEventResponse> getOwnerDisactivationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERDISACTIVATION_EVENT, transactionReceipt);
        ArrayList<OwnerDisactivationEventResponse> responses = new ArrayList<OwnerDisactivationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnerDisactivationEventResponse typedResponse = new OwnerDisactivationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.disactivatedOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnerDisactivationEventResponse> ownerDisactivationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnerDisactivationEventResponse>() {
            @Override
            public OwnerDisactivationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERDISACTIVATION_EVENT, log);
                OwnerDisactivationEventResponse typedResponse = new OwnerDisactivationEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.disactivatedOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnerDisactivationEventResponse> ownerDisactivationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERDISACTIVATION_EVENT));
        return ownerDisactivationEventFlowable(filter);
    }

    public List<RevokeConfirmationEventResponse> getRevokeConfirmationEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REVOKECONFIRMATION_EVENT, transactionReceipt);
        ArrayList<RevokeConfirmationEventResponse> responses = new ArrayList<RevokeConfirmationEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RevokeConfirmationEventResponse typedResponse = new RevokeConfirmationEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RevokeConfirmationEventResponse> revokeConfirmationEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RevokeConfirmationEventResponse>() {
            @Override
            public RevokeConfirmationEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REVOKECONFIRMATION_EVENT, log);
                RevokeConfirmationEventResponse typedResponse = new RevokeConfirmationEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RevokeConfirmationEventResponse> revokeConfirmationEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REVOKECONFIRMATION_EVENT));
        return revokeConfirmationEventFlowable(filter);
    }

    public List<SubmitTransactionEventResponse> getSubmitTransactionEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SUBMITTRANSACTION_EVENT, transactionReceipt);
        ArrayList<SubmitTransactionEventResponse> responses = new ArrayList<SubmitTransactionEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SubmitTransactionEventResponse typedResponse = new SubmitTransactionEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<SubmitTransactionEventResponse> submitTransactionEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, SubmitTransactionEventResponse>() {
            @Override
            public SubmitTransactionEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SUBMITTRANSACTION_EVENT, log);
                SubmitTransactionEventResponse typedResponse = new SubmitTransactionEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.txIndex = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.data = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<SubmitTransactionEventResponse> submitTransactionEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUBMITTRANSACTION_EVENT));
        return submitTransactionEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addOwner(String _owner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> approveOwner(String _owner, List<BigInteger> nonces, List<byte[]> signatures) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_APPROVEOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(nonces, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(signatures, org.web3j.abi.datatypes.DynamicBytes.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> confirmTransaction(BigInteger _txIndex) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CONFIRMTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_txIndex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> confirmationsRequired() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONFIRMATIONSREQUIRED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> disactivateOwner(String _owner, List<BigInteger> nonces, List<byte[]> signatures) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_DISACTIVATEOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.datatypes.generated.Uint256.class,
                        org.web3j.abi.Utils.typeMap(nonces, org.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.DynamicBytes>(
                        org.web3j.abi.datatypes.DynamicBytes.class,
                        org.web3j.abi.Utils.typeMap(signatures, org.web3j.abi.datatypes.DynamicBytes.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> executeTransaction(BigInteger _txIndex) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_EXECUTETRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_txIndex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> getEthSignedHash(byte[] _message) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETETHSIGNEDHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_message)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<List> getOwners() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETOWNERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<Tuple5<String, BigInteger, byte[], Boolean, BigInteger>> getTransaction(BigInteger _txIndex) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_txIndex)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple5<String, BigInteger, byte[], Boolean, BigInteger>>(function,
                new Callable<Tuple5<String, BigInteger, byte[], Boolean, BigInteger>>() {
                    @Override
                    public Tuple5<String, BigInteger, byte[], Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, BigInteger, byte[], Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> getTransactionCount() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETTRANSACTIONCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> isConfirmed(BigInteger param0, String param1) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISCONFIRMED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.Address(160, param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isOwner(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> owners(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> revokeConfirmation(BigInteger _txIndex) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REVOKECONFIRMATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_txIndex)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<byte[], byte[], BigInteger>> splitSignature(byte[] signature) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_SPLITSIGNATURE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicBytes(signature)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple3<byte[], byte[], BigInteger>>(function,
                new Callable<Tuple3<byte[], byte[], BigInteger>>() {
                    @Override
                    public Tuple3<byte[], byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<byte[], byte[], BigInteger>(
                                (byte[]) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> submitTransaction(String _to, BigInteger _value, byte[] _data) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_SUBMITTRANSACTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.DynamicBytes(_data)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple5<String, BigInteger, byte[], Boolean, BigInteger>> transactions(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRANSACTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>() {}, new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple5<String, BigInteger, byte[], Boolean, BigInteger>>(function,
                new Callable<Tuple5<String, BigInteger, byte[], Boolean, BigInteger>>() {
                    @Override
                    public Tuple5<String, BigInteger, byte[], Boolean, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<String, BigInteger, byte[], Boolean, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (byte[]) results.get(2).getValue(), 
                                (Boolean) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Boolean> usedNonces(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_USEDNONCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> verify(byte[] _ethSignedMessage, byte[] _signanture) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VERIFY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_ethSignedMessage), 
                new org.web3j.abi.datatypes.DynamicBytes(_signanture)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static BearWallet_sol_MultiSigBearWallet load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new BearWallet_sol_MultiSigBearWallet(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static BearWallet_sol_MultiSigBearWallet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new BearWallet_sol_MultiSigBearWallet(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static BearWallet_sol_MultiSigBearWallet load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new BearWallet_sol_MultiSigBearWallet(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static BearWallet_sol_MultiSigBearWallet load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new BearWallet_sol_MultiSigBearWallet(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<BearWallet_sol_MultiSigBearWallet> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, List<String> _owners, BigInteger _confirmationsRequired) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_owners, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_confirmationsRequired)));
        return deployRemoteCall(BearWallet_sol_MultiSigBearWallet.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<BearWallet_sol_MultiSigBearWallet> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, List<String> _owners, BigInteger _confirmationsRequired) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_owners, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_confirmationsRequired)));
        return deployRemoteCall(BearWallet_sol_MultiSigBearWallet.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<BearWallet_sol_MultiSigBearWallet> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> _owners, BigInteger _confirmationsRequired) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_owners, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_confirmationsRequired)));
        return deployRemoteCall(BearWallet_sol_MultiSigBearWallet.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<BearWallet_sol_MultiSigBearWallet> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> _owners, BigInteger _confirmationsRequired) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(_owners, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.generated.Uint256(_confirmationsRequired)));
        return deployRemoteCall(BearWallet_sol_MultiSigBearWallet.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ConfirmTransactionEventResponse extends BaseEventResponse {
        public String owner;

        public BigInteger txIndex;
    }

    public static class DepositEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;

        public BigInteger balance;
    }

    public static class ExecuteTransactionEventResponse extends BaseEventResponse {
        public String owner;

        public BigInteger txIndex;
    }

    public static class OwnerAdditionEventResponse extends BaseEventResponse {
        public String sender;

        public String newOwner;
    }

    public static class OwnerApprovalEventResponse extends BaseEventResponse {
        public String sender;

        public String approvedOwner;
    }

    public static class OwnerDisactivationEventResponse extends BaseEventResponse {
        public String sender;

        public String disactivatedOwner;
    }

    public static class RevokeConfirmationEventResponse extends BaseEventResponse {
        public String owner;

        public BigInteger txIndex;
    }

    public static class SubmitTransactionEventResponse extends BaseEventResponse {
        public String owner;

        public BigInteger txIndex;

        public String to;

        public BigInteger value;

        public byte[] data;
    }
}
