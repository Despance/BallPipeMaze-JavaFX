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
                tile = new StarterTile(tempIndex/4,tempIndex%4,"/Starter.png");
                tile.rotateTile(90);
                list.add(tempIndex, tile);
                break;
            case "Horizontal" :
                tile = new StarterTile(tempIndex/4,tempIndex%4,"/Starter.png");
                list.add(tempIndex, tile);
                break;

            default:
                System.out.println("input not recognized");
                break;
        }



    }

    public void ControlOfTheSecondForEmpty(int tempIndex, String s){
        switch (s){


            case "none" :
                tile = new BlockTile(tempIndex/4,tempIndex%4,"/Block.png");
                list.add(tempIndex, tile);
                break;

            case "Free" :
                tile = new FreeTile(tempIndex/4,tempIndex%4,"/Free.png");
                list.add(tempIndex, tile);
                break;

            default:
                System.out.println("input not recognized");
                break;

        }



    }

    public void ControlOfTheSecondForPipe(int tempIndex, String s){

        switch (s){

            case "Vertical" :
                tile = new PipeTile(tempIndex/4,tempIndex%4,"/Pipe.png");
                tile.rotateTile(90);
                list.add(tempIndex, tile);
                break;
            case "Horizontal" :
                tile = new PipeTile(tempIndex/4,tempIndex%4,"/Pipe.png");
                list.add(tempIndex, tile);
                break;

            default:
                System.out.println("input not recognized");
                break;
        }



    }

    public void ControlOfTheSecondForEnd(int tempIndex, String s){
        switch (s) {

            case "Vertical" :
                tile = new StarterTile(tempIndex/4,tempIndex%4,"/Starter.png");
                tile.rotateTile(90);
                list.add(tempIndex, tile);
                break;
            case "Horizontal" :
                tile = new StarterTile(tempIndex/4,tempIndex%4,"/Starter.png");
                list.add(tempIndex, tile);
                break;

            default:
                System.out.println("input not recognized");
                break;


        }
    }

    public void ControlOfTheSecondForPipeStatic(int tempIndex, String s){
        switch (s){

            case "Vertical" :
                tile = new PipeStaticTile(tempIndex/4,tempIndex%4,"/PipeStatic.png");
                tile.rotateTile(90);
                list.add(tempIndex, tile);
                break;
            case "Horizontal" :
                tile = new PipeStaticTile(tempIndex/4,tempIndex%4,"/PipeStatic.png");
                list.add(tempIndex, tile);
                break;

            case "00" :
                tile = new PipeStaticTile(tempIndex/4,tempIndex%4,"/CurvedPipeStatic.png");
                tile.rotateTile(180);
                list.add(tempIndex, tile);
                break;

            case "01" :
                tile = new PipeStaticTile(tempIndex/4,tempIndex%4,"/CurvedPipeStatic.png");
                tile.rotateTile(270);
                list.add(tempIndex, tile);
                break;

            case "10" :
                tile = new PipeStaticTile(tempIndex/4,tempIndex%4,"/CurvedPipeStatic.png");
                list.add(tempIndex, tile);
                break;

            case "11" :
                tile = new PipeStaticTile(tempIndex/4,tempIndex%4,"/CurvedPipeStatic.png");
                tile.rotateTile(90);
                list.add(tempIndex, tile);
                break;

            default:
                System.out.println("input not recognized");
                break;
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
