// import example.GreeterImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {

    public static void main(String[] args) throws Exception {

        Server server = ServerBuilder.forPort(50051)
                .addService(new GreeterImpl())
                .build()
                .start();

        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

        server.awaitTermination();

    }
}