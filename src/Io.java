import Tiles.*;

import java.io.File;
import java.util.*;


public class Io {
    // some variables we will use
    private Tile[] list;
    private File file;
    Scanner input;
    // default constructor
    public Io(){

    }
    // constructor which sets file
    public Io(File file){
        this.file = file;

    }
    // this method is used to read the input file and to create a Tiles array
    public void decodeInput(){
       // checking if the file exists
        try {
           if (file.exists()) {
               input = new Scanner(file);
           }
           else
               throw new Exception("File Not Found");
       }
       // if the file doesn't exist the program stops
       catch(Exception ex){
           System.out.println(ex.getLocalizedMessage());
           System.exit(1);
       }
            //create array that will hold our tiles
            list = new Tile[16];
           // some temporary values
           String[] tempStringArray;
           int index;
           // here we read the input file
           while (input.hasNext()){
               // here we take the input and are storing it in a String array
               String tempS = input.nextLine();
               if(tempS.equals(""))
                   continue;
               tempStringArray = tempS.split(",");
               // here we find the index in which the tile will go
               index = Integer.parseInt(tempStringArray[0])-1;
                // here determine the tile type and call the tiles constructor
               // in the constructor we also pass the modifier of the tile
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
    // here are some setter and getter methods
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


}
