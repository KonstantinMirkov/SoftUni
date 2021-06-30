package com.JavaAdvanced.DefiningClasses.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carsCount = Integer.parseInt(scanner.nextLine());

        List<CarData> cars = new LinkedList<>();

        while (carsCount-- > 0){
            String[] carInfo =scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoW = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];

            ArrayList<Tyres> tyres = new ArrayList<>();
            Tyres tyre = new Tyres(Double.parseDouble(carInfo[5]), Integer.parseInt(carInfo[6]),
                    Double.parseDouble(carInfo[7]), Integer.parseInt(carInfo[8]),
                    Double.parseDouble(carInfo[9]), Integer.parseInt(carInfo[10]),
                    Double.parseDouble(carInfo[11]), Integer.parseInt(carInfo[12]));

            tyres.add(tyre);

            CarData car = new CarData(model, engineSpeed, enginePower, cargoW, cargoType, tyres);
            cars.add(car);
        }
        String type = scanner.nextLine();
        if (type.equals("fragile")) {
            List<String> model = new ArrayList<>();
            cars.forEach(car ->{

                if (car.getTyres().get(0).getPressure1() < 1 || car.getTyres().get(0).getPressure2() < 1
                        || car.getTyres().get(0).getPressure3() < 1 || car.getTyres().get(0).getPressure4() < 1) {
                    model.add(car.getModel());
                }

            });
            model.forEach(System.out::println);
        } else {
            cars.forEach(e -> {
                if (e.getEnginePower() >= 250) {
                    System.out.println(String.format("%s", e.getModel()));
                }
            });
        }
    }
}
