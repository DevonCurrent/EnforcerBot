package main.java;

    // Piece Sub-class
    public class Piece {
        private String id;

        Piece() {
            id = "	";
        }
        Piece(String x) {
            id = x;
        }

    public String getID() {
        return id;
        }

    public boolean equals(Piece p) {
        return this.getID().equals(p.getID()) && !this.getID().equals(" ");
        }
    }
