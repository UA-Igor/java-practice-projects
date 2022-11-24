public final class Construction {
    private final int length;
    private final int wheels;
    private final int seats; //include driver
    Construction(int length, int wheels, int seats){
        this.length = length;
        this.wheels = wheels;
        this.seats = seats;
    }

    public int getLength() {
        return length;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString(){
        return "Construction: " + length + " length, "
                + wheels + " wheels, " + seats + " seats";
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        else if (o instanceof Construction cs) {
            return (cs.getLength() == this.length)
                    && (cs.getSeats() == this.seats)
                    && (cs.getWheels() == this.wheels);
        }
        return false;
    }

    @Override
    public int hashCode(){
        int result = 31 + length;
        result = 31 * result + seats;
        result = 31 * result + wheels;
        return result;
    }
}
