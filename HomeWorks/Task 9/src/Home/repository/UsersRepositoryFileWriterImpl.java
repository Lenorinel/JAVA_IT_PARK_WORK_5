package Home.repository;

import Home.models.User;
import Home.util.IdGenerator;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsersRepositoryFileWriterImpl implements UsersRepository {
    private FileWriter writer;
    private Reader reader;
    private String fileName;
    private IdGenerator idGenerator;
    private String line, line2;
    private int idFind;
    private int a = 0;
    private String name, secondName;
    private String patt = "yyyy-MM-dd";
    private LocalDate dateLocal;

    public UsersRepositoryFileWriterImpl(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    @Override
    public User find(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("userfind.txt", false));

            while ((line = reader.readLine()) != null) {
                for (String value : line.split(" ")) {
                    if (value.equals(String.valueOf(id))) {


                        writer.write(line);
                    }
                }
            }
            reader.close();
            writer.close();
            BufferedReader read = new BufferedReader(new FileReader("userfind.txt"));
            line2 = read.readLine();
            for (String value : line2.split(" ")) {
                a++;
                if (a == 1) {
                    idFind = Integer.parseInt(value);
                }
                if (a == 4) {
                    DateTimeFormatter date = DateTimeFormatter.ofPattern(patt);
                    dateLocal = LocalDate.parse(value, date);
                }
                if (a == 2) {
                    this.name = value;
                }
                if (a == 3) {
                    this.secondName = value;
                }

            }
            User user = new User(name, secondName, dateLocal);
            reader.close();
            return user;


        } catch (IOException ex) {
            throw new IllegalStateException(ex);

        }

    }

    @Override
    public void delete(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter("users2.txt"));
            while ((line = reader.readLine()) != null) {
                for (String value : line.split(" ")) {
                    if (value.equals(String.valueOf(id))) {
                        writer.write(line);
                        writer.newLine();
                    }
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
                    + user.getFirstName() + " "
                    + user.getSecondName() + " "
                    + user.getBirthDate().toString() + "\n");
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
                for (String value : line.split(" ")) {
                    if (value.equals(String.valueOf(user.getId()))) {
                        writer.write(user.getId() + " "
                                + user.getFirstName() + " "
                                + user.getSecondName() + " "
                                + user.getBirthDate());
                        writer.newLine();
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
            reader.close();
            writer.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
