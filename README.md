# Comandos para rodar o projeto

- Iniciar o registrador RMI

```rmiregistry &```

- Buildar a interface

```javac -d build/classes/java/main/ src/main/java/ResumeInterface.java src/main/java/Payload.java```

- Run Server

```javac -d build/classes/java/main/ src/main/java/Server.java src/main/java/Payload.java src/main/java/ResumeService.java src/main/java/ResumeInterface.java```

```java -classpath build/classes/java/main/ Server (from root folder)```

- Run Client

```javac -d build/classes/java/main/ src/main/java/Client.java  src/main/java/ResumeInterface.java src/main/java/Payload.java```

```java -classpath build/classes/java/main/ Client```

