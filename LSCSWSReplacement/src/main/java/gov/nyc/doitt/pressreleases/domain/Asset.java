package gov.nyc.doitt.pressreleases.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity(name="asset")
public class Asset {
	@Id
	private long id;
	@Column(name="asset_id")
	private String assetId;
	@Column(name="deleted")
	@Type(type="numeric_boolean")
	private boolean deleted;
	@Column(name="marked_for_delete")
	@Type(type="numeric_boolean")
	private boolean markedForDelete;
	
	@OneToOne
	@JoinColumn(name="context")
	private Context context;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isMarkedForDelete() {
		return markedForDelete;
	}

	public void setMarkedForDelete(boolean markedForDelete) {
		this.markedForDelete = markedForDelete;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	
}
