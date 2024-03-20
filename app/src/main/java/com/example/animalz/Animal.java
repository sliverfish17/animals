package com.example.animalz;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {
    private int imageId;
    private String name;
    private String description;

    public Animal(int imageId, String name, String description) {
        this.imageId = imageId;
        this.name = name;
        this.description = description;
    }

    protected Animal(Parcel in) {
        imageId = in.readInt();
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(name);
        dest.writeString(description);
    }
}
