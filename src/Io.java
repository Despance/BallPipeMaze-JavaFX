import Tiles.*;

import java.io.File;
import java.util.*;


public class Io {

    private Tile[] list;
    private File file;
    Scanner input;

    Tile tile;

    public Io(File file){
        this.file = file;

    }
    public void decodeInput(){
       try {
           if (file.exists()) {
               input = new Scanner(file);
           }
           else
               throw new Exception("File Not Found");
       }
       catch(Exception ex){
           System.out.println(ex.getLocalizedMessage());
           System.exit(1);
       }
            list = new Tile[16];
           String[] tempStringArray;
           int index;

           while (input.hasNext()){

               String tempS = input.nextLine();
               if(tempS.equals(""))
                   continue;
               tempStringArray = tempS.split(",");
               index = Integer.parseInt(tempStringArray[0])-1;

                switch (tempStringArray[1].toLowerCase()){

                   case "starter" :
                       list[index]= new StarterTile(index/4,index%4,tempStringArray[2].toLowerCase());
                       break;

                   case "empty" :
                       if(tempStringArray[2].toLowerCase().equals("free"))
                           list[index]= new FreeTile(index/4,index%4);
                       else
                           list[index]= new EmptyTile(index/4,index%4);
                       break;

                   case "pipe" :
                       if(tempStringArray[2].toLowerCase().equals("horizontal") || tempStringArray[2].toLowerCase().equals("vertical"))
                           list[index]= new PipeTile(index/4,index%4,tempStringArray[2].toLowerCase());
                       else
                           list[index]=  new CurvedPipeTile(index/4,index%4,tempStringArray[2].toLowerCase());
                       break;

                   case "end" :
                       list[index]= new EndTile(index/4,index%4,tempStringArray[2].toLowerCase());
                       break;

                   case "pipestatic" :
                       if(tempStringArray[2].toLowerCase().equals("horizontal") || tempStringArray[2].toLowerCase().equals("vertical"))
                           list[index]=  new PipeStaticTile(index/4,index%4,tempStringArray[2].toLowerCase());
                       else
                           list[index]= new CurvedPipeStaticTile(index/4,index%4,tempStringArray[2].toLowerCase());
                       break;

               }


           }




    }

    public Tile[] getList() {
        return list;
    }

    public void setList(Tile[] list) {
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

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
