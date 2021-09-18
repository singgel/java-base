package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueDogCat {
    public class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getPetType() {
            return this.pet.type;
        }
    }

    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public QueueDogCat() {
        this.dogQueue = new LinkedBlockingDeque<>();
        this.catQueue = new LinkedBlockingDeque<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.type)) {
            this.dogQueue.add(new PetEnterQueue(pet, System.currentTimeMillis()));
        } else {
            this.catQueue.add(new PetEnterQueue(pet, System.currentTimeMillis()));
        }
    }

    public Pet pollAll() {
        if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                return dogQueue.peek().pet;
            } else {
                return catQueue.peek().pet;
            }
        } else if (!catQueue.isEmpty()) {
            return catQueue.peek().pet;
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.peek().pet;
        } else {
            throw new RuntimeException("no pet");
        }
    }

    public Dog pollDog(){
        return (Dog) dogQueue.peek().pet;
    }
}
