package com.JavaAdvanced.DefiningClasses.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Engine>> engineParameters = new HashMap<>();
        int parametersLength;
        int enginesCount = Integer.parseInt(sc.nextLine());
        boolean hasNumber;
        for (int i = 0; i < enginesCount; i++) {
            String[] parameters = sc.nextLine().split("\\s+");
            String engineModel = parameters[0];
            String power = parameters[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            parametersLength = parameters.length;
            if (parametersLength == 3) {
                String current = parameters[2];
                hasNumber = checkForNumbers(current);
                if (hasNumber) {
                    displacement = current;
                } else {
                    efficiency = current;
                }
            }

            if (parametersLength > 3) {
                displacement = parameters[2];
                efficiency = parameters[3];
            }

            Engine currentEngine = new Engine(engineModel, power, displacement, efficiency);
            engineParameters.putIfAbsent(engineModel, new ArrayList<>());
            engineParameters.get(engineModel).add(currentEngine);
        }


        Map<Integer, List<CarInformation>> carParameters = new LinkedHashMap<>();

        int quantityCars = Integer.parseInt(sc.nextLine());

        for (int position = 0; position < quantityCars; position++) {
            String[] parameters = sc.nextLine().split("\\s+");
            String model = parameters[0];
            String engine = parameters[1];
            String weight = "n/a";
            String color = "n/a";
            parametersLength = parameters.length;
            if (parametersLength == 3) {
                String current = parameters[2];
                hasNumber = checkForNumbers(current);
                if (hasNumber) {
                    weight = current;
                } else {
                    color = current;
                }
            }

            if (parametersLength == 4) {
                weight = parameters[2];
                color = parameters[3];
            }

            Engine enginePerThisCar = getParticularEngine(engine, engineParameters);
            CarInformation currentCar = new CarInformation(model, enginePerThisCar, weight, color);
            carParameters.putIfAbsent(position, new ArrayList<>());
            carParameters.get(position).add(currentCar);
        }


        for (Map.Entry<Integer, List<CarInformation>> currentElement : carParameters.entrySet()) {
            currentElement.getValue().forEach(e->
                    System.out.printf("%s:" + "\n" + "  %s:\n" +
                            "    Power: %s\n" +
                            "    Displacement: %s\n" +
                            "    Efficiency: %s\n" +
                            "  Weight: %s\n" +
                            "  Color: %s%n",e.getModel(),
                    e.getEngine().getEngineModel(),
                    e.getEngine().getPower(),
                    e.getEngine().getDisplacement(),
                    e.getEngine().getEfficiency(),
                    e.getWeight(),e.getColor()));
        }
    }

    private static Engine getParticularEngine(String engine, Map<String, List<Engine>> engineParameters) {
        List<Engine> temp = new ArrayList<>();
        Engine engine1;
        for (Map.Entry<String, List<Engine>> element : engineParameters.entrySet()) {
            String modelCurrent = element.getKey();
            if (modelCurrent.equals(engine)) {
                String specificModel = element
                        .getValue().get(0).getEngineModel();
                String power = element.getValue().get(0).getPower();
                String displacement = element.getValue().get(0).getDisplacement();

                String efficiency = element.getValue().get(0).getEfficiency();
                return engine1 = new Engine(specificModel, power, displacement, efficiency);
            }
        }
        return null;
    }

    private static boolean checkForNumbers(String currentNumber) {
        for (int i = 0; i < currentNumber.length(); i++) {
            int ascii = currentNumber.charAt(i);
            if (ascii > 47 && ascii < 58) {
                return true;
            }
        }
        return false;

    }
}
