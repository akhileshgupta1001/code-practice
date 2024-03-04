package com.designe.pattern.factory.phone;

public class OperatingSystemFactory {
    public OS getInstance(String os){
        if("Android".equalsIgnoreCase(os)){
            return new Android();
        }else if("Ios".equalsIgnoreCase(os)){
            return new Ios();
        }else if("Window".equalsIgnoreCase(os)){
            return new Window();
        }
        return null;
    }

    public static void main(String[] args) {
        OperatingSystemFactory factory = new OperatingSystemFactory();
        factory.getInstance("Android").spec();
    }
}
