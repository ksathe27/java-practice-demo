package com.ksathe.javapracticedemo.leetcode;

import java.util.*;

public class Solution1776 {
    //https://leetcode.com/problems/car-fleet-ii/

    public double[] getCollisionTimes(int[][] cars) {
        List<MyCar> allCars = new ArrayList<>();
        int index = 0;
        for (int[] car: cars) {
            MyCar myCar = new MyCar(index, car[0], car[1]);
            allCars.add(myCar);
            index++;
        }

        boolean flag = true;
        List<MyCar> result = new ArrayList<>();
        while(flag) {
            double collisionTime = nextCollisionTime(allCars);

            Iterator<MyCar> carIterator = allCars.iterator();
            while (carIterator.hasNext()
                    && Double.compare(collisionTime, -1.0) != 0
                    && Double.compare(collisionTime, Double.MAX_VALUE) == -1) {
                MyCar cc = carIterator.next();
                // update curr location for all remaining ones in allCars
                cc.location = cc.location + cc.speed*collisionTime;
                if (Double.compare(cc.nextCollisionTime, collisionTime) == 0) {
                    carIterator.remove();
                    cc.hasCollided = true;
                    result.add(cc);
                }
            }

            // if no change update flag to false below
            if (Double.compare(collisionTime, Double.MAX_VALUE) == 0) {
                flag = false;
            }
        }

        double[] finalResult = new double[cars.length];
        Arrays.fill(finalResult, -1);
        for (MyCar c: result) {
            finalResult[c.index] = (c.location - cars[c.index][0])/c.speed;
        }
        return finalResult;
    }

    private double nextCollisionTime(List<MyCar> cars) {
        //if (cars.size() < 2) return -1.0;
        double minTime = Double.MAX_VALUE;
        MyCar curr = cars.get(0);
        for (int ind=1; ind<cars.size(); ind++) {
            MyCar next = cars.get(ind);
            if (curr.speed > next.speed) {
                double time = (next.location - curr.location)/(curr.speed - next.speed);
                minTime = Math.min(minTime, time);
                curr.nextCollisionTime = time;
            }
            curr = next;
        }
        return minTime;
    }

    private class MyCar {
        int index;
        double location;
        double speed;
        boolean hasCollided;
        double nextCollisionTime;
        public MyCar(int ind, double loc, double sp) {
            index = ind;
            location = loc;
            speed = sp;
            hasCollided = false;
            nextCollisionTime = -1.0;
        }
    }
}
