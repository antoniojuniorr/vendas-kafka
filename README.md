Interface Gráfica Kafka: Conduktor


Kafka CLI:

Zookeeper start
	zookeeper-server-start.bat C:\Apps\kafka\config\zookeeper.properties

Kafka start
	kafka-server-start.bat C:\Apps\kafka\config\server.properties

Listar Topicos:
	kafka-topics --bootstrap-server localhost:9092 --list
	
Criar Topicos
	kafka-topics --bootstrap-server localhost:9092 --create --topic teste
	
Produzir mensagem
	kafka-console-producer.bat --broker--list localhost:9092 --topic teste
	
Iniciar consumer para ler mensagem
	kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic teste
	kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic teste --group grupo1
	
Iniciar consumer para ler mensagem desde o inicio
	kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic teste --from-beginning
