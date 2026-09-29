class AnnalynsInfiltration {

    public static void main(String[] args) {
        System.out.println("Fast attack: " + canFastAttack(false));
        System.out.println("Spy: " + canSpy(true, false, false));
        System.out.println("Signal prisoner: " + canSignalPrisoner(false, true));
        System.out.println("Free prisoner: " + canFreePrisoner(false, false, true, false));
    }

    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        return prisonerIsAwake && !archerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        return petDogIsPresent && !archerIsAwake
                || !petDogIsPresent && prisonerIsAwake && !knightIsAwake && !archerIsAwake;
    }
}