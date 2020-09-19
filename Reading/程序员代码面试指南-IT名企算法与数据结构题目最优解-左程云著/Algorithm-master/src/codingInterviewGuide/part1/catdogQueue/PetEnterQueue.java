package codingInterviewGuide.part1.catdogQueue;

/**
 * Created by Dell on 2017-07-19.
 */
public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public String getPetType(){
        return pet.getType();
    }

    public Pet getPet() {
        return pet;
    }


    public long getCount() {
        return count;
    }

}
