package Home;

import Home.models.User;
import Home.models.UserHand;
import Home.util.idGenerationFileBased;
import Home.repository.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileWriterImpl("users.txt",idGenerationFileBased.generator());
        User Adel = new User("Adel","Kaym", LocalDate.of(1932,10,18));
        User Ade2 = new User("Adel2","Kaym1", LocalDate.of(1992,10,18));
        User Ade3 = new User("Adel3","Kaym2", LocalDate.of(1993,10,18));
        User Ade4 = new User("Adel4","Kaym3", LocalDate.of(1994,10,18));
        User Ade5 = new User("Shit", "Happend", LocalDate.of(1990,01,9));
       // UserHand Dog = new UserHand(3,"Good","Boy", LocalDate.of(2016,01,14)); с созданием доп класса
        usersRepository.save(Adel);
        usersRepository.save(Ade2);
        usersRepository.save(Ade3);
        usersRepository.save(Ade4);

//        usersRepository.save(Dog);
//        usersRepository.delete(4);
//        Ade5.setId(1); //с изменением айди до сохранения объекта.
//        usersRepository.update(Ade5);
       // System.out.println(Dog.getId());
        System.out.println(usersRepository.find(48).toString());
    }
}
