import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {
    String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plantList = new ArrayList<>();
        String[] rows = garden.split("\n");

        for (String row :rows){
            char studentChar = 65;
            for (int i = 0; i < row.length(); i = i+2) {
                if (student.charAt(0) == studentChar++) {
//                    System.out.println(row.substring(i, i + 2));
                    plantList.add(Plant.getPlant(row.substring(i, i + 2).charAt(0)));
                    plantList.add(Plant.getPlant(row.substring(i, i + 2).charAt(1)));
                }
            }
        }
        return plantList;
    }

}
