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
public class Channel_sol_PaymentChannel extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50604051610bbf380380610bbf83398101604081905261002f91610054565b600380546001600160a01b0319166001600160a01b0392909216919091179055610084565b60006020828403121561006657600080fd5b81516001600160a01b038116811461007d57600080fd5b9392505050565b610b2c806100936000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80638e8a87ef1161005b5780638e8a87ef1461011657806399413b4e14610129578063a7bb58031461013c578063b7ab4db51461016d57600080fd5b8063258ae5821461008d5780632f4ea5ea146100bd578063410b9c05146100de57806365a8613c146100f3575b600080fd5b6100a061009b3660046107e5565b610182565b6040516001600160a01b0390911681526020015b60405180910390f35b6100d06100cb36600461082c565b610202565b6040519081526020016100b4565b6100f16100ec366004610861565b610255565b005b6101066101013660046107e5565b610451565b60405190151581526020016100b4565b6100f16101243660046108c2565b6104c7565b6100f161013736600461096f565b61056e565b61014f61014a366004610991565b6105e0565b60408051938452602084019290925260ff16908201526060016100b4565b610175610652565b6040516100b491906109ce565b600080600080610191856105e0565b6040805160008152602081018083528b905260ff8316918101919091526060810184905260808101839052929550909350915060019060a0016020604051602081039080840390855afa1580156101ec573d6000803e3d6000fd5b5050506020604051035193505050505b92915050565b6040517f19457468657265756d205369676e6564204d6573736167653a0a3332000000006020820152603c8101829052600090605c01604051602081830303815290604052805190602001209050919050565b60008281526020819052604090205460ff16156102b15760405162461bcd60e51b81526020600482015260156024820152741393d390d157d254d7d053149150511657d554d151605a1b60448201526064015b60405180910390fd5b600082815260208181526040808320805460ff1916600117905551606087901b6bffffffffffffffffffffffff19169181019190915260348101859052605481018490526103179060740160405160208183030381529060405280519060200120610202565b90506103238183610451565b61036f5760405162461bcd60e51b815260206004820181905260248201527f4449474954414c5f5349474e41545552455f49535f4e4f545f47454e55494e4560448201526064016102a8565b6002546003546040516323b872dd60e01b81526001600160a01b0391821660048201528782166024820152604481018790529116906323b872dd906064016020604051808303816000875af11580156103cc573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906103f09190610a1b565b50816040516103ff9190610a3d565b6040805191829003822086835260208301869052916001600160a01b038816917f439e97f6510420d1c0a80ded1e38ef053e9f7fdc940d11c9b6485a8a4ff1087d910160405180910390a35050505050565b60008061045e8484610182565b905060005b6001548110156104bc576001818154811061048057610480610a78565b6000918252602090912001546001600160a01b03838116911614156104aa576001925050506101fc565b806104b481610a8e565b915050610463565b506000949350505050565b6003546001600160a01b031633146105175760405162461bcd60e51b815260206004820152601360248201527229a2a72222a92fa4a9afa727aa2fa7aba722a960691b60448201526064016102a8565b805161052a9060019060208401906106b4565b50806040516105399190610ab7565b6040519081900381209033907ffcf631ce6c9189d727fe8780772e788a9fa14032b34ecfbae9af10aec88b629890600090a350565b6003546001600160a01b031633146105be5760405162461bcd60e51b815260206004820152601360248201527229a2a72222a92fa4a9afa727aa2fa7aba722a960691b60448201526064016102a8565b600280546001600160a01b0319166001600160a01b0392909216919091179055565b600080600083516041146106365760405162461bcd60e51b815260206004820152601860248201527f494e56414c49445f5349474e41545552455f4c454e475448000000000000000060448201526064016102a8565b50505060208101516040820151606083015160001a9193909250565b606060018054806020026020016040519081016040528092919081815260200182805480156106aa57602002820191906000526020600020905b81546001600160a01b0316815260019091019060200180831161068c575b5050505050905090565b828054828255906000526020600020908101928215610709579160200282015b8281111561070957825182546001600160a01b0319166001600160a01b039091161782556020909201916001909101906106d4565b50610715929150610719565b5090565b5b80821115610715576000815560010161071a565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff8111828210171561076d5761076d61072e565b604052919050565b600082601f83011261078657600080fd5b813567ffffffffffffffff8111156107a0576107a061072e565b6107b3601f8201601f1916602001610744565b8181528460208386010111156107c857600080fd5b816020850160208301376000918101602001919091529392505050565b600080604083850312156107f857600080fd5b82359150602083013567ffffffffffffffff81111561081657600080fd5b61082285828601610775565b9150509250929050565b60006020828403121561083e57600080fd5b5035919050565b80356001600160a01b038116811461085c57600080fd5b919050565b6000806000806080858703121561087757600080fd5b61088085610845565b93506020850135925060408501359150606085013567ffffffffffffffff8111156108aa57600080fd5b6108b687828801610775565b91505092959194509250565b600060208083850312156108d557600080fd5b823567ffffffffffffffff808211156108ed57600080fd5b818501915085601f83011261090157600080fd5b8135818111156109135761091361072e565b8060051b9150610924848301610744565b818152918301840191848101908884111561093e57600080fd5b938501935b838510156109635761095485610845565b82529385019390850190610943565b98975050505050505050565b60006020828403121561098157600080fd5b61098a82610845565b9392505050565b6000602082840312156109a357600080fd5b813567ffffffffffffffff8111156109ba57600080fd5b6109c684828501610775565b949350505050565b6020808252825182820181905260009190848201906040850190845b81811015610a0f5783516001600160a01b0316835292840192918401916001016109ea565b50909695505050505050565b600060208284031215610a2d57600080fd5b8151801515811461098a57600080fd5b6000825160005b81811015610a5e5760208186018101518583015201610a44565b81811115610a6d576000828501525b509190910192915050565b634e487b7160e01b600052603260045260246000fd5b6000600019821415610ab057634e487b7160e01b600052601160045260246000fd5b5060010190565b815160009082906020808601845b83811015610aea5781516001600160a01b031685529382019390820190600101610ac5565b5092969550505050505056fea264697066735822122021405137ecc9125544b2bae357d525b7641e429837513125cd1dbbcd40ce416564736f6c634300080b0033";

    public static final String FUNC_CLAIMPAYMENT = "claimPayment";

    public static final String FUNC_CONNECTTOKEN = "connectToken";

    public static final String FUNC_GETETHSIGNEDHASH = "getEthSignedHash";

    public static final String FUNC_GETVALIDATORS = "getValidators";

    public static final String FUNC_REPLACEVALIDATORS = "replaceValidators";

    public static final String FUNC_SPLITSIGNATURE = "splitSignature";

    public static final String FUNC_VALIDATE = "validate";

    public static final String FUNC_VERIFY = "verify";

    public static final Event REPLACEMENTVALIDATORS_EVENT = new Event("ReplacementValidators", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<DynamicArray<Address>>(true) {}));
    ;

    public static final Event WITHDRAWAL_EVENT = new Event("Withdrawal", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<DynamicBytes>(true) {}));
    ;

    @Deprecated
    protected Channel_sol_PaymentChannel(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Channel_sol_PaymentChannel(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Channel_sol_PaymentChannel(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Channel_sol_PaymentChannel(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ReplacementValidatorsEventResponse> getReplacementValidatorsEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REPLACEMENTVALIDATORS_EVENT, transactionReceipt);
        ArrayList<ReplacementValidatorsEventResponse> responses = new ArrayList<ReplacementValidatorsEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReplacementValidatorsEventResponse typedResponse = new ReplacementValidatorsEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.validators = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReplacementValidatorsEventResponse> replacementValidatorsEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ReplacementValidatorsEventResponse>() {
            @Override
            public ReplacementValidatorsEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REPLACEMENTVALIDATORS_EVENT, log);
                ReplacementValidatorsEventResponse typedResponse = new ReplacementValidatorsEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.validators = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReplacementValidatorsEventResponse> replacementValidatorsEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REPLACEMENTVALIDATORS_EVENT));
        return replacementValidatorsEventFlowable(filter);
    }

    public List<WithdrawalEventResponse> getWithdrawalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAWAL_EVENT, transactionReceipt);
        ArrayList<WithdrawalEventResponse> responses = new ArrayList<WithdrawalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawalEventResponse typedResponse = new WithdrawalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.player = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.sig = (byte[]) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.payment = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.nonce = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WithdrawalEventResponse> withdrawalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, WithdrawalEventResponse>() {
            @Override
            public WithdrawalEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAWAL_EVENT, log);
                WithdrawalEventResponse typedResponse = new WithdrawalEventResponse();
                typedResponse.log = log;
                typedResponse.player = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.sig = (byte[]) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.payment = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.nonce = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WithdrawalEventResponse> withdrawalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWAL_EVENT));
        return withdrawalEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> claimPayment(String _reciever, BigInteger payment, BigInteger nonce, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLAIMPAYMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _reciever), 
                new org.web3j.abi.datatypes.generated.Uint256(payment), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.DynamicBytes(sig)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> connectToken(String token) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CONNECTTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, token)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<byte[]> getEthSignedHash(byte[] _message) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETETHSIGNEDHASH, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_message)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<List> getValidators() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETVALIDATORS, 
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

    public RemoteFunctionCall<TransactionReceipt> replaceValidators(List<String> validators) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REPLACEVALIDATORS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.datatypes.Address.class,
                        org.web3j.abi.Utils.typeMap(validators, org.web3j.abi.datatypes.Address.class))), 
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

    public RemoteFunctionCall<Boolean> validate(byte[] message, byte[] sig) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_VALIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(message), 
                new org.web3j.abi.datatypes.DynamicBytes(sig)), 
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
    public static Channel_sol_PaymentChannel load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Channel_sol_PaymentChannel(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Channel_sol_PaymentChannel load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Channel_sol_PaymentChannel(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Channel_sol_PaymentChannel load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Channel_sol_PaymentChannel(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Channel_sol_PaymentChannel load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Channel_sol_PaymentChannel(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Channel_sol_PaymentChannel> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(Channel_sol_PaymentChannel.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Channel_sol_PaymentChannel> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(Channel_sol_PaymentChannel.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Channel_sol_PaymentChannel> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(Channel_sol_PaymentChannel.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Channel_sol_PaymentChannel> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _owner)));
        return deployRemoteCall(Channel_sol_PaymentChannel.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class ReplacementValidatorsEventResponse extends BaseEventResponse {
        public String owner;

        public byte[] validators;
    }

    public static class WithdrawalEventResponse extends BaseEventResponse {
        public String player;

        public byte[] sig;

        public BigInteger payment;

        public BigInteger nonce;
    }
}
