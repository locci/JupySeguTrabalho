package sql;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static  void main(String[] args){

        //Main.sqlTables();
        //Main.sqlIncereColuna();
        //Main.sqlUpdate();
        Main.drop();


    }

    public static void sqlTables () {

        File fi = new File("/home/alexandre/Desktop/out");

        try (FileWriter fw = new FileWriter(fi)) {

            for(int i =1; i <= 200; i++)
                fw.write("create table ator_" + i + " as select film_actor.film_id, actor.actor_id from film_actor " +
                        "INNER JOIN actor ON film_actor.actor_id = actor.actor_id and actor.actor_id=" + i + ";" + "\n");

            fw.close();



        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void sqlIncereColuna () {

        File fi = new File("/home/alexandre/Desktop/outcol");

        try (FileWriter fw = new FileWriter(fi)) {

            fw.write("ALTER TABLE dataset_quatro" + " ADD ator_" + 1 + " int AFTER " + "num_de;" + "\n");


            for(int i = 2; i <= 200; i++)

                fw.write("ALTER TABLE dataset_quatro" + " ADD ator_" + i + " int AFTER " + "actor_" + (i - 1) + ";" + "\n");

            fw.close();



        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void sqlUpdate () {

        File fi = new File("/home/alexandre/Desktop/outupdate");

        try (FileWriter fw = new FileWriter(fi)) {


            for(int i = 1; i <= 200; i++) {

                fw.write("UPDATE dataset_quatro SET ator_"+ i + "= 1" + " WHERE film_id IN (SELECT film_id FROM ator_" + i + " WHERE dataset_quatro.film_id = ator_" + i+ ".film_id);" + "\n");
            }

            fw.close();



        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void drop() {


        File fi = new File("/home/alexandre/Desktop/outdrop");

        try (FileWriter fw = new FileWriter(fi)) {


            for(int i = 1; i <= 200; i++) {

                fw.write("DROP TABLE " + "ator_" + i + ";" + "\n");
            }

            fw.close();



        } catch (IOException e) {

            e.printStackTrace();

        }

    }


}

