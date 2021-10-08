import example.grpc.helloworld.GreeterGrpc;
import example.grpc.helloworld.HelloReply;
import example.grpc.helloworld.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void testApp() {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setName("Thom").build();
        HelloReply response = blockingStub.sayHello(request);

        System.out.println(response.getMessage());
        assertEquals(response.getMessage(), "Hello Thom");
    }
}