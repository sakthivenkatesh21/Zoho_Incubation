package zohoincubation.oops.changes.liskovsubstitutionprinciple.afterLSP;

public  class  Vechicle {
    public String getBrand(){
        return "brand";
    }
    public void start() {
        System.out.println("Vehicle Start");
    }

    public void stop() {
        System.out.println(" Vehicle  stopped.");
    }
}
    

   