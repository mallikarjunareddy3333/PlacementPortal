package ecms.placement.portal.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NotificationDto {
	
	@NotEmpty
	@NotNull
	private String title;
	
	@NotEmpty
	@NotNull
	private String body;

	public NotificationDto() {
		// TODO Auto-generated constructor stub
	}

	public NotificationDto(String title, String body) {
		this.title = title;
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
