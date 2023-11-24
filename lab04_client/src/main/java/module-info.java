module io.github.skippertokozak.lab04.client
{
    opens io.github.skippertokozak.lab04.client.data to com.google.gson;
    requires com.google.gson;
    requires java.net.http;
    exports io.github.skippertokozak.lab04.client;
}