import java.io.*;

public class PlantUMLRunner {
    private static String plantUMLPath;
    public static void setJarPath(String plantUMLPath){
        PlantUMLRunner.plantUMLPath = plantUMLPath;
    }

    public static void generetaDiagram(String umlData, String dirPath, String filename) throws IOException, InterruptedException {
        umlData = "@startuml\n" + umlData + "\n@enduml";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new IOException("Nie udalo sie utworzyc katalogu: "+dir.getAbsolutePath());
            }
        }
        File outDiagram = new File(dir, filename);

        Process plantUMLProccess = new ProcessBuilder(
                "java", "-jar", plantUMLPath, "-pipe"
        ).redirectOutput(outDiagram).start();

        Writer writer = new BufferedWriter(new OutputStreamWriter(plantUMLProccess.getOutputStream()));
        writer.write(umlData);
        writer.close();

        int exitCode = plantUMLProccess.waitFor();
        if(exitCode != 0){
            System.err.println("PlantUML zakonczyl sie bledem"+exitCode);
        }
    }
}
