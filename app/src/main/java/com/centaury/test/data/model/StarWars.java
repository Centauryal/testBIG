package com.centaury.test.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class StarWars implements Parcelable {

	@SerializedName("next")
	private String next;

	@SerializedName("count")
	private int count;

	@SerializedName("results")
	private List<ResultsItem> results;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"StarWars{" + 
			"next = '" + next + '\'' +
			",count = '" + count + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.next);
		dest.writeInt(this.count);
		dest.writeTypedList(this.results);
	}

	public StarWars() {
	}

	protected StarWars(Parcel in) {
		this.next = in.readString();
		this.count = in.readInt();
		this.results = in.createTypedArrayList(ResultsItem.CREATOR);
	}

	public static final Parcelable.Creator<StarWars> CREATOR = new Parcelable.Creator<StarWars>() {
		@Override
		public StarWars createFromParcel(Parcel source) {
			return new StarWars(source);
		}

		@Override
		public StarWars[] newArray(int size) {
			return new StarWars[size];
		}
	};
}