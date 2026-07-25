package functionalProgramming.lambdaandmethodreference;

class City {
    private double latitude;
    private double longitude;

    public City(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    double getLatitude() {
        return latitude;
    }

    double getLongitude() {
        return longitude;
    }

    void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
