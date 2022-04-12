package br.com.elo7.sonda.candidato.v2.probes.model;

public enum Direction {
    NORTH{
        @Override
        public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {

            int newVerticalPosition = coordinate.getVerticalAxis()+value;
            int maxVerticalPosition = planet.getHeight();

            if(newVerticalPosition > maxVerticalPosition){
                newVerticalPosition -= maxVerticalPosition;
            }

            return new Coordinate(coordinate.getHorizontalAxis(),newVerticalPosition);
        }
    }, EAST {
        @Override
        public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {

            int newHorizontalPosition = coordinate.getHorizontalAxis()+value;
            int maxHorizontalPosition = planet.getWith();

            if(newHorizontalPosition > maxHorizontalPosition){
                newHorizontalPosition -= maxHorizontalPosition;
            }

            return new Coordinate(newHorizontalPosition,coordinate.getVerticalAxis());
        }
    }, SOUTH {
        @Override
        public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {
            int newVerticalPosition = coordinate.getVerticalAxis()-value;
            int maxVerticalPosition = planet.getHeight();

            if(newVerticalPosition < 0){
                newVerticalPosition += maxVerticalPosition;
            }

            return new Coordinate(coordinate.getHorizontalAxis(),newVerticalPosition);
        }
    }, WEST {
        @Override
        public Coordinate moveOn(int value, Coordinate coordinate, Planet planet) {
            int newHorizontalPosition = coordinate.getHorizontalAxis()-value;
            int maxHorizontalPosition = planet.getWith();

            if(newHorizontalPosition < 0){
                newHorizontalPosition += maxHorizontalPosition;
            }

            return new Coordinate(newHorizontalPosition,coordinate.getVerticalAxis());
        }
    };

    public abstract Coordinate moveOn(int value,Coordinate coordinate, Planet planet);
}
