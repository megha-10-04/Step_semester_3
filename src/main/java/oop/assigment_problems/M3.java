package oop.assigment_problems;

abstract class GardenTool {

    public String use() {
        return "Using the tool in the garden";
    }
}

class CuttingTool extends GardenTool {

    @Override
    public String use() {
        return super.use() + ", blade sharpened first";
    }
}

class Pruner extends CuttingTool {

    @Override
    public String use() {
        return super.use() + ", trimming branches precisely";
    }
}

public class M3 {

    public static void main(String[] args) {

        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();

        System.out.println(c.use());
        System.out.println(p.use());
    }
}