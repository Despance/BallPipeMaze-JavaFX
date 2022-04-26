import javafx.scene.image.ImageView;

import java.io.File;
import java.util.*;

// burda yaptığım input dosyasını alıp ArrayListe tile locationını atamak
public class Io {
/*
    private ArrayList<Tiles> list = new ArrayList<>(16);
    private File file;
    Scanner input;

    public Io(){
    }
    public Io(File file){
        this.file = file;
        DecodeInput();
    }
    public void DecodeInput(){
       try {
           if (file.exists()) {
               input = new Scanner(file);
           }
           else
               throw new Exception("File Not Found");
       }
       catch(Exception ex){
           System.out.println(ex);
           System.exit(1);
       }

           String[] tempStringArray;
           int index;

           while (input.hasNext()){

               String tempS = input.nextLine();
               if(tempS.equals(""))
                   continue;
               tempStringArray = tempS.split(",");
               index = Integer.parseInt(tempStringArray[0]);

               switch (tempStringArray[1]){

                   case "Starter" :
                       ControlOfTheSecondForStarter(index, tempStringArray[2]);
                       break;

                   case "Empty" :
                       ControlOfTheSecondForEmpty(index, tempStringArray[2]);
                       break;

                   case "Pipe" :
                       ControlOfTheSecondForPipe(index, tempStringArray[2]);
                       break;

                   case "End" :
                       ControlOfTheSecondForEnd(index, tempStringArray[2]);
                       break;

                   case "PipeStatic" :
                       ControlOfTheSecondForPipeStatic(index, tempStringArray[2]);
                       break;

               }


           }




    }

    public void ControlOfTheSecondForStarter(int tempIndex, String s){
        switch (s){

            case "Vertical" :
                Tiles image = new Starter();
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                Tiles image1 = new Starter();
                ((Starter)image1).turnImageView(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                Tiles image2 = new Block();
                list.add(tempIndex, image2);
                break;

            case "Free" :
                Tiles image3 = new Free();
                list.add(tempIndex, image3);
                break;

            case "00" :
                Tiles image4 = new CurvedPipe();
                list.add(tempIndex, image4);
                break;

            case "01" :
                Tiles image5 = new CurvedPipe();
                ((CurvedPipe)image5).turnImageView(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                Tiles image6 = new CurvedPipe();
                ((CurvedPipe)image6).turnImageView(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                Tiles image7 = new CurvedPipe();
                ((CurvedPipe)image7).turnImageView(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public void ControlOfTheSecondForEmpty(int tempIndex, String s){
        switch (s){

            case "Vertical" :
                Tiles image = new Pipe();
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                Tiles image1 = new Pipe();
                ((Pipe)image1).turnImageView(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                Tiles image2 = new Block();
                list.add(tempIndex, image2);
                break;

            case "Free" :
                Tiles image3 = new Free();
                list.add(tempIndex, image3);
                break;

            case "00" :
                Tiles image4 = new CurvedPipe();
                list.add(tempIndex, image4);
                break;

            case "01" :
                Tiles image5 = new CurvedPipe();
                ((CurvedPipe)image5).turnImageView(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                Tiles image6 = new CurvedPipe();
                ((CurvedPipe)image6).turnImageView(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                Tiles image7 = new CurvedPipe();
                ((CurvedPipe)image7).turnImageView(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public void ControlOfTheSecondForPipe(int tempIndex, String s){

        switch (s){

            case "Vertical" :
                Tiles image = new Pipe();
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                Tiles image1 = new Pipe();
                ((Pipe)image1).turnImageView(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                Tiles image2 = new Block();
                list.add(tempIndex, image2);
                break;

            case "Free" :
                Tiles image3 = new Free();
                list.add(tempIndex, image3);
                break;

            case "00" :
                Tiles image4 = new CurvedPipe();
                list.add(tempIndex, image4);
                break;

            case "01" :
                Tiles image5 = new CurvedPipe();
                ((CurvedPipe)image5).turnImageView(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                Tiles image6 = new CurvedPipe();
                ((CurvedPipe)image6).turnImageView(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                Tiles image7 = new CurvedPipe();
                ((CurvedPipe)image7).turnImageView(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public void ControlOfTheSecondForEnd(int tempIndex, String s){
        switch (s) {

            case "Vertical" :
                Tiles image = new End();
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                Tiles image1 = new End();
                ((End)image1).turnImageView(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                Tiles image2 = new Block();
                list.add(tempIndex, image2);
                break;

            case "Free" :
                Tiles image3 = new Free();
                list.add(tempIndex, image3);
                break;

            case "00" :
                Tiles image4 = new CurvedPipe();
                list.add(tempIndex, image4);
                break;

            case "01" :
                Tiles image5 = new CurvedPipe();
                ((CurvedPipe)image5).turnImageView(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                Tiles image6 = new CurvedPipe();
                ((CurvedPipe)image6).turnImageView(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                Tiles image7 = new CurvedPipe();
                ((CurvedPipe)image7).turnImageView(270);
                list.add(tempIndex, image7);
                break;


        }
    }

    public void ControlOfTheSecondForPipeStatic(int tempIndex, String s){
        switch (s){

            case "Vertical" :
                Tiles image = new PipeStatic();
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                Tiles image1 = new PipeStatic();
                ((PipeStatic)image1).turnImageView(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                Tiles image2 = new Block();
                list.add(tempIndex, image2);
                break;

            case "Free" :
                Tiles image3 = new Free();
                list.add(tempIndex, image3);
                break;

            case "00" :
                Tiles image4 = new CurvedPipe();
                list.add(tempIndex, image4);
                break;

            case "01" :
                Tiles image5 = new CurvedPipe();
                ((CurvedPipe)image5).turnImageView(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                Tiles image6 = new CurvedPipe();
                ((CurvedPipe)image6).turnImageView(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                Tiles image7 = new CurvedPipe();
                ((CurvedPipe)image7).turnImageView(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public ArrayList<Tiles> getList() {
        return list;
    }

    public void setList(ArrayList<Tiles> list) {
        this.list = list;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }*/
}
