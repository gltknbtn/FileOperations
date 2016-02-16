package csvoperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CsvOperationManager {

    public static void main(String[] args) {

        createImageDirectoryWithLabel("\\\\b740nt1\\Grkm\\Datasets\\Face\\LFW\\lfw_selected\\lfw_selected\\lfw-selected_1Gallery_99Probe_probe.csv");

    }

    private static void createImageDirectoryWithLabel(String csvPath) {

        try {
            String parentFileName = new File(csvPath).getName();
            String[] stringArr = parentFileName.split("\\.");
            File toBeCreatedParentDir = new File(new File(csvPath).getParent() + "/"
                    + new SimpleDateFormat("yyyy-MM-dd_HH-ss-mm").format(new Date()) + "_"
                    + stringArr[0]);
            toBeCreatedParentDir.mkdir();

            BufferedReader reader = new BufferedReader(new FileReader(csvPath));
            String separator = ";";
            String line = null;
            List<CsvEntity> csvEntityList = new ArrayList<CsvEntity>();

            while ((line = reader.readLine()) != null) {
                String[] strArr = line.split(separator);
                CsvEntity csvEntity = new CsvEntity();
                csvEntity.setImagePath(strArr[0]);
                csvEntity.setImageLabel(strArr[1]);
                csvEntityList.add(csvEntity);
            }
            reader.close();

            for (int i = 0; i < csvEntityList.size(); i++) {

                File toBeCopiedFile = new File(csvEntityList.get(i).getImagePath());
                File toBeCreatedLabelDir = new File(toBeCreatedParentDir + "/" + csvEntityList.get(i).getImageLabel());
                if (!toBeCreatedLabelDir.exists()) {
                    toBeCreatedLabelDir.mkdir();
                    FileUtils.copyFileToDirectory(toBeCopiedFile, toBeCreatedLabelDir);
                } else {
                    FileUtils.copyFileToDirectory(toBeCopiedFile, toBeCreatedLabelDir);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
