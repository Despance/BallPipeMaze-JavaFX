import Tiles.*;

import java.io.File;
import java.util.*;

// burda yaptığım input dosyasını alıp ArrayListe tile locationını atamak
public class Io {

    private ArrayList<Tile> list = new ArrayList<>(16);
    private File file;
    Scanner input;

    Tile tile;

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
                       list.add(new StarterTile(index/4,index%4,tempStringArray[2]));
                       break;

                   case "Empty" :
                       if(tempStringArray[2].equals("Free"))
                           list.add(new FreeTile(index/4,index%4));
                       else
                           list.add(new EmptyTile(index/4,index%4));
                       break;

                   case "Pipe" :
                       if(tempStringArray[2].equals("Horizontal") || tempStringArray[2].equals("Vertical"))
                           list.add(new PipeTile(index/4,index%4,tempStringArray[2]));
                       else
                           list.add(new CurvedPipeTile(index/4,index%4,tempStringArray[2]));
                       break;

                   case "End" :
                       list.add(new EndTile(index/4,index%4,tempStringArray[2]));
                       break;

                   case "PipeStatic" :
                       if(tempStringArray[2].equals("Horizontal") || tempStringArray[2].equals("Vertical"))
                           list.add(new PipeStaticTile(index/4,index%4,tempStringArray[2]));
                       else
                           list.add(new CurvedPipeStaticTile(index/4,index%4,tempStringArray[2]));
                       break;

               }


           }




    }

    public ArrayList<Tile> getList() {
        return list;
    }

    public void setList(ArrayList<Tile> list) {
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
