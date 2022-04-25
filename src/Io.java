import javafx.scene.image.ImageView;

import java.io.File;
import java.util.*;

// burda yaptığım input dosyasını alıp ArrayListe tile locationını atamak
public class Io {

    private ArrayList<ImageView> list = new ArrayList<>(16);
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
               tempStringArray = input.nextLine().split(",");
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
                ImageView image = new Pipe().getImage();
                image.setRotate(0);
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                ImageView image1 = new Pipe().getImage();
                image1.setRotate(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                ImageView image2 = new Block().getImage();
                image2.setRotate(0);
                list.add(tempIndex, image2);
                break;

            case "Free" :
                ImageView image3 = new Free().getImage();
                image3.setRotate(0);
                list.add(tempIndex, image3);
                break;

            case "00" :
                ImageView image4 = new CurvedPipe().getImage();
                image4.setRotate(0);
                list.add(tempIndex, image4);
                break;

            case "01" :
                ImageView image5 = new CurvedPipe().getImage();
                image5.setRotate(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                ImageView image6 = new CurvedPipe().getImage();
                image6.setRotate(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                ImageView image7 = new CurvedPipe().getImage();
                image7.setRotate(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public void ControlOfTheSecondForEmpty(int tempIndex, String s){
        switch (s){

            case "Vertical" :
                ImageView image = new Pipe().getImage();
                image.setRotate(0);
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                ImageView image1 = new Pipe().getImage();
                image1.setRotate(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                ImageView image2 = new Block().getImage();
                image2.setRotate(0);
                list.add(tempIndex, image2);
                break;

            case "Free" :
                ImageView image3 = new Free().getImage();
                image3.setRotate(0);
                list.add(tempIndex, image3);
                break;

            case "00" :
                ImageView image4 = new CurvedPipe().getImage();
                image4.setRotate(0);
                list.add(tempIndex, image4);
                break;

            case "01" :
                ImageView image5 = new CurvedPipe().getImage();
                image5.setRotate(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                ImageView image6 = new CurvedPipe().getImage();
                image6.setRotate(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                ImageView image7 = new CurvedPipe().getImage();
                image7.setRotate(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public void ControlOfTheSecondForPipe(int tempIndex, String s){

        switch (s){

            case "Vertical" :
                ImageView image = new Pipe().getImage();
                image.setRotate(0);
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                ImageView image1 = new Pipe().getImage();
                image1.setRotate(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                ImageView image2 = new Block().getImage();
                image2.setRotate(0);
                list.add(tempIndex, image2);
                break;

            case "Free" :
                ImageView image3 = new Free().getImage();
                image3.setRotate(0);
                list.add(tempIndex, image3);
                break;

            case "00" :
                ImageView image4 = new CurvedPipe().getImage();
                image4.setRotate(0);
                list.add(tempIndex, image4);
                break;

            case "01" :
                ImageView image5 = new CurvedPipe().getImage();
                image5.setRotate(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                ImageView image6 = new CurvedPipe().getImage();
                image6.setRotate(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                ImageView image7 = new CurvedPipe().getImage();
                image7.setRotate(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public void ControlOfTheSecondForEnd(int tempIndex, String s){
        switch (s) {

            case "Vertical":
                ImageView image = new Pipe().getImage();
                image.setRotate(0);
                list.add(tempIndex, image);
                break;
            case "Horizontal":
                ImageView image1 = new Pipe().getImage();
                image1.setRotate(90);
                list.add(tempIndex, image1);
                break;
            case "none":
                ImageView image2 = new Block().getImage();
                image2.setRotate(0);
                list.add(tempIndex, image2);
                break;

            case "Free":
                ImageView image3 = new Free().getImage();
                image3.setRotate(0);
                list.add(tempIndex, image3);
                break;

            case "00":
                ImageView image4 = new CurvedPipe().getImage();
                image4.setRotate(0);
                list.add(tempIndex, image4);
                break;

            case "01":
                ImageView image5 = new CurvedPipe().getImage();
                image5.setRotate(90);
                list.add(tempIndex, image5);
                break;

            case "10":
                ImageView image6 = new CurvedPipe().getImage();
                image6.setRotate(180);
                list.add(tempIndex, image6);
                break;

            case "11":
                ImageView image7 = new CurvedPipe().getImage();
                image7.setRotate(270);
                list.add(tempIndex, image7);
                break;


        }
    }

    public void ControlOfTheSecondForPipeStatic(int tempIndex, String s){
        switch (s){

            case "Vertical" :
                ImageView image = new Pipe().getImage();
                image.setRotate(0);
                list.add(tempIndex, image);
                break;
            case "Horizontal" :
                ImageView image1 = new Pipe().getImage();
                image1.setRotate(90);
                list.add(tempIndex, image1);
                break;
            case "none" :
                ImageView image2 = new Block().getImage();
                image2.setRotate(0);
                list.add(tempIndex, image2);
                break;

            case "Free" :
                ImageView image3 = new Free().getImage();
                image3.setRotate(0);
                list.add(tempIndex, image3);
                break;

            case "00" :
                ImageView image4 = new CurvedPipe().getImage();
                image4.setRotate(0);
                list.add(tempIndex, image4);
                break;

            case "01" :
                ImageView image5 = new CurvedPipe().getImage();
                image5.setRotate(90);
                list.add(tempIndex, image5);
                break;

            case "10" :
                ImageView image6 = new CurvedPipe().getImage();
                image6.setRotate(180);
                list.add(tempIndex, image6);
                break;

            case "11" :
                ImageView image7 = new CurvedPipe().getImage();
                image7.setRotate(270);
                list.add(tempIndex, image7);
                break;
        }



    }

    public ArrayList<ImageView> getList() {
        return list;
    }

    public void setList(ArrayList<ImageView> list) {
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
    }
}
