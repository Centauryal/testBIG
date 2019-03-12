package com.centaury.test.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItem implements Parcelable {

	@SerializedName("films")
	private List<String> films;

	@SerializedName("homeworld")
	private String homeworld;

	@SerializedName("gender")
	private String gender;

	@SerializedName("skin_color")
	private String skinColor;

	@SerializedName("edited")
	private String edited;

	@SerializedName("created")
	private String created;

	@SerializedName("mass")
	private String mass;

	@SerializedName("vehicles")
	private List<String> vehicles;

	@SerializedName("url")
	private String url;

	@SerializedName("hair_color")
	private String hairColor;

	@SerializedName("birth_year")
	private String birthYear;

	@SerializedName("eye_color")
	private String eyeColor;

	@SerializedName("species")
	private List<String> species;

	@SerializedName("starships")
	private List<String> starships;

	@SerializedName("name")
	private String name;

	@SerializedName("height")
	private String height;

	public void setFilms(List<String> films){
		this.films = films;
	}

	public List<String> getFilms(){
		return films;
	}

	public void setHomeworld(String homeworld){
		this.homeworld = homeworld;
	}

	public String getHomeworld(){
		return homeworld;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setSkinColor(String skinColor){
		this.skinColor = skinColor;
	}

	public String getSkinColor(){
		return skinColor;
	}

	public void setEdited(String edited){
		this.edited = edited;
	}

	public String getEdited(){
		return edited;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setMass(String mass){
		this.mass = mass;
	}

	public String getMass(){
		return mass;
	}

	public void setVehicles(List<String> vehicles){
		this.vehicles = vehicles;
	}

	public List<String> getVehicles(){
		return vehicles;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHairColor(String hairColor){
		this.hairColor = hairColor;
	}

	public String getHairColor(){
		return hairColor;
	}

	public void setBirthYear(String birthYear){
		this.birthYear = birthYear;
	}

	public String getBirthYear(){
		return birthYear;
	}

	public void setEyeColor(String eyeColor){
		this.eyeColor = eyeColor;
	}

	public String getEyeColor(){
		return eyeColor;
	}

	public void setSpecies(List<String> species){
		this.species = species;
	}

	public List<String> getSpecies(){
		return species;
	}

	public void setStarships(List<String> starships){
		this.starships = starships;
	}

	public List<String> getStarships(){
		return starships;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"films = '" + films + '\'' + 
			",homeworld = '" + homeworld + '\'' + 
			",gender = '" + gender + '\'' + 
			",skin_color = '" + skinColor + '\'' + 
			",edited = '" + edited + '\'' + 
			",created = '" + created + '\'' + 
			",mass = '" + mass + '\'' + 
			",vehicles = '" + vehicles + '\'' + 
			",url = '" + url + '\'' + 
			",hair_color = '" + hairColor + '\'' + 
			",birth_year = '" + birthYear + '\'' + 
			",eye_color = '" + eyeColor + '\'' + 
			",species = '" + species + '\'' + 
			",starships = '" + starships + '\'' + 
			",name = '" + name + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringList(this.films);
		dest.writeString(this.homeworld);
		dest.writeString(this.gender);
		dest.writeString(this.skinColor);
		dest.writeString(this.edited);
		dest.writeString(this.created);
		dest.writeString(this.mass);
		dest.writeStringList(this.vehicles);
		dest.writeString(this.url);
		dest.writeString(this.hairColor);
		dest.writeString(this.birthYear);
		dest.writeString(this.eyeColor);
		dest.writeStringList(this.species);
		dest.writeStringList(this.starships);
		dest.writeString(this.name);
		dest.writeString(this.height);
	}

	public ResultsItem() {
	}

	protected ResultsItem(Parcel in) {
		this.films = in.createStringArrayList();
		this.homeworld = in.readString();
		this.gender = in.readString();
		this.skinColor = in.readString();
		this.edited = in.readString();
		this.created = in.readString();
		this.mass = in.readString();
		this.vehicles = in.createStringArrayList();
		this.url = in.readString();
		this.hairColor = in.readString();
		this.birthYear = in.readString();
		this.eyeColor = in.readString();
		this.species = in.createStringArrayList();
		this.starships = in.createStringArrayList();
		this.name = in.readString();
		this.height = in.readString();
	}

	public static final Parcelable.Creator<ResultsItem> CREATOR = new Parcelable.Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel source) {
			return new ResultsItem(source);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};
}