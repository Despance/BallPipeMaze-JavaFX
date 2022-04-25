import java.io.File;
import java.util.*;

// burda yaptığım input dosyasını alıp ArrayListe tile locationını atamak
public class Io {

    private ArrayList<String> list = new ArrayList<>(16);
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

    public void ControlOfTheSecondForStarter(int index, String s){
        switch (s){

            case "Vertical" :
                list.add(index, "location");
                break;
            case "Horizontal" :
                list.add(index, "location");
                break;
            case "none" :
                list.add(index, "location");
                break;

            case "Free" :
                list.add(index, "location");
                break;

            case "00" :
                list.add(index, "location");
                break;

            case "01" :
                list.add(index, "location");
                break;

            case "10" :
                list.add(index, "location");
                break;

            case "11" :
                list.add(index, "location");
                break;
        }



    }

    public void ControlOfTheSecondForEmpty(int index, String s){
        switch (s){

            case "Vertical" :
                list.add(index, "location");
                break;
            case "Horizontal" :
                list.add(index, "location");
                break;
            case "none" :
                list.add(index, "location");
                break;

            case "Free" :
                list.add(index, "location");
                break;

            case "00" :
                list.add(index, "location");
                break;

            case "01" :
                list.add(index, "location");
                break;

            case "10" :
                list.add(index, "location");
                break;

            case "11" :
                list.add(index, "location");
                break;
        }



    }

    public void ControlOfTheSecondForPipe(int index, String s){
        switch (s){

            case "Vertical" :
                list.add(index, "location");
                break;
            case "Horizontal" :
                list.add(index, "location");
                break;
            case "none" :
                list.add(index, "location");
                break;

            case "Free" :
                list.add(index, "location");
                break;

            case "00" :
                list.add(index, "location");
                break;

            case "01" :
                list.add(index, "location");
                break;

            case "10" :
                list.add(index, "location");
                break;

            case "11" :
                list.add(index, "location");
                break;
        }



    }

    public void ControlOfTheSecondForEnd(int index, String s){
        switch (s){

            case "Vertical" :
                list.add(index, "location");
                break;
            case "Horizontal" :
                list.add(index, "location");
                break;
            case "none" :
                list.add(index, "location");
                break;

            case "Free" :
                list.add(index, "location");
                break;

            case "00" :
                list.add(index, "location");
                break;

            case "01" :
                list.add(index, "location");
                break;

            case "10" :
                list.add(index, "location");
                break;

            case "11" :
                list.add(index, "location");
                break;
        }



    }

    public void ControlOfTheSecondForPipeStatic(int index, String s){
        switch (s){

            case "Vertical" :
                list.add(index, "location");
                break;
            case "Horizontal" :
                list.add(index, "location");
                break;
            case "none" :
                list.add(index, "location");
                break;

            case "Free" :
                list.add(index, "location");
                break;

            case "00" :
                list.add(index, "location");
                break;

            case "01" :
                list.add(index, "location");
                break;

            case "10" :
                list.add(index, "location");
                break;

            case "11" :
                list.add(index, "location");
                break;
        }



    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
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
