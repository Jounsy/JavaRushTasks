package com.javarush.task.task31.task3110;

/**
 * Created by Work-TESTER on 11.09.2017.
 */
public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private  int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public long getCompressionRatio(){
        return 100-((compressedSize * 100)/ size);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        if (size > 0) {
            builder.append("\t");
            builder.append(size / 1024);
            builder.append(" Kb (");
            builder.append(compressedSize / 1024);
            builder.append(" Kb) сжатие: ");
            builder.append(getCompressionRatio());
            builder.append("%");
        }

        return builder.toString();
// валидатор не принимает
//        String string = name;
//
//        if(size>0){
//            string = "\t" + size / 1024 + " Kb (" + compressedSize / 1024 + " Kb) сжатие: " + getCompressionRatio() + "%";
//
//        }
// return string;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }
}
