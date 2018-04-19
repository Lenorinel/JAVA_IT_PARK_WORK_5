package Home.repository;

import Home.models.User;
import Home.util.IdGenerator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.io.*;

public class UsersRepositoryFileWriterImpl implements UsersRepository {
    private FileWriter writer;
    private Reader reader;
    private String fileName;
    private IdGenerator idGenerator;
    private String line;

    public UsersRepositoryFileWriterImpl(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    @Override
    public User find(int id) {
        return null;
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//            while ((line = reader.readLine()) != null) {
//                if (!line.startsWith(String.valueOf(id))) {
//                    ;
//
//                } else System.out.println("User not found");
//            }
//            reader.close();
//        } catch (IOException ex) {
//            throw new IllegalStateException(ex);

    }


    @Override
    public void delete(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("users2.txt"));
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(String.valueOf(id))) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }


    @Override
    public void save(User user) {
        try {
            writer = new FileWriter(fileName, true);
            writer.write(idGenerator.getNewId() + " "
                    + user.getBirthDate().toString() + " "
                    + user.getFirstName() + " "
                    + user.getSecondName() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public void update(User user) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("user3.txt"));
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(String.valueOf(user.getId()))) {
                    writer.write(user.getId() + " "
                            + user.getBirthDate() + " "
                            + user.getFirstName() + " "
                            + user.getSecondName());
                    writer.newLine();
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
