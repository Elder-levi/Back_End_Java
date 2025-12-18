# 📄 TechMec Application

**Descrição:**  
Uma aplicação em Java que utiliza o Spring Framework com o objetivo de gerenciar as ordens de serviços e equipamentos.

---

## 🔧 Tecnologias utilizadas

- Java 17  
- Spring Boot 3.5.7  
- Maven  
- Hibernate / JPA  
- MySQL (via MySQL Workbench)  
- IntelliJ IDEA (IDE para desenvolvimento e execução da aplicação)  

---

## ⚙️ Instalação e execução

1. Baixe o arquivo da aplicação no formato `.zip` e extraia-o em uma pasta de sua preferência.  
2. Abra o IntelliJ IDEA.  
   - Se houver algum projeto aberto, feche-o (`File > Close Project`).  
   - Na tela inicial, clique em `Open` e selecione a pasta do projeto que você acabou de extrair.  
3. Abra o MySQL Workbench e crie uma nova conexão `localhost`.  
   - Por padrão, utilize usuário `root` sem senha.  
   - **Atenção:** se você usar outro usuário ou senha, lembre-se de atualizar os dados correspondentes no arquivo `application.properties` do projeto:  
     ```properties
     spring.datasource.username=<seu_usuario>
     spring.datasource.password=<sua_senha>
     ```  
4. Crie o schema (database) com o nome exato: `TechMec`.  
5. Localize o arquivo de script SQL do banco de dados na pasta do projeto.  
   - Abra o arquivo, copie todo o conteúdo e cole no MySQL Workbench.  
   - Execute os comandos para criar as tabelas no schema `TechMec`.  
6. No IntelliJ, abra o arquivo `AplicacaoApplication.java`.  
   - Clique na **seta preta com bordas verdes** localizada na parte superior, ao lado do símbolo de inseto (debug), para executar a aplicação Spring Boot.  
7. Depois de seguir todos os passos anteriores, a aplicação estará inicializada em `http://localhost:8090` e pronta para uso.  
8. Utilize o Postman para testar as rotas seguindo a documentação de rotas fornecida.

9. Diagrama De Classe
   <br>
   <img width="800" height="800" alt="NovoCasoDeUso" src="https://github.com/user-attachments/assets/58c719d7-b23b-40ef-bbe4-9990f5d4aa9b" />
