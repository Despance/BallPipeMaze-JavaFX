import java.io.File;
import java.util.*;

// burda yaptığım input dosyasını alıp ArrayListe tile locationını atamak
public class Io {

    private ArrayList<String> list = new ArrayList<>();
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
                       ControlOfTheSecond(tempStringArray[2]);
                       break;

                   case "Empty" :
                       ControlOfTheSecond(tempStringArray[2]);
                       break;

                   case "Pipe" :
                       ControlOfTheSecond(tempStringArray[2]);
                       break;

                   case "End" :
                       ControlOfTheSecond(tempStringArray[2]);
                       break;

                   case "PipeStatic" :
                       ControlOfTheSecond(tempStringArray[2]);
                       break;

               }


           }




    }

    public void ControlOfTheSecond(String s){
        switch (s){

            case "Vertical" :
                list.add("location");
                break;
            case "Horizontal" :
                list.add("location");
                break;
            case "none" :
                list.add("location");
                break;

            case "Free" :
                list.add("location");
                break;

            case "00" :
                list.add("location");
                break;

            case "01" :
                list.add("location");
                break;

            case "10" :
                list.add("location");
                break;

            case "11" :
                list.add("location");
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
