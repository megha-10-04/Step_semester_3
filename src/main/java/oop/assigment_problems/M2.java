package oop.assigment_problems;

abstract class ArtPiece {

    private static int counter = 1;
    private final int pieceId;
    protected String title;

    ArtPiece(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }

        this.title = title;
        this.pieceId = counter++;
    }

    public abstract String describe();

    public int getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {

    Painting(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {

    Sculpture(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class M2 {

    public static void main(String[] args) {

        Painting p = new Painting("Sunset Fields");
        Sculpture s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(s.describe());

        System.out.println("Painting ID: " + p.getPieceId());
        System.out.println("Sculpture ID: " + s.getPieceId());
    }
}