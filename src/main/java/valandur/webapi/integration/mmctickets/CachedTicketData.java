package valandur.webapi.integration.mmctickets;

import net.moddedminecraft.mmctickets.data.TicketData;
import net.moddedminecraft.mmctickets.data.ticketStatus;
import valandur.webapi.api.cache.CachedObject;
import valandur.webapi.api.cache.player.ICachedPlayer;
import valandur.webapi.api.cache.world.CachedLocation;
import valandur.webapi.api.serialize.JsonDetails;

public class CachedTicketData extends CachedObject<TicketData> {

    private int id;
    public int getId() {
        return id;
    }

    private long timestamp;
    public long getTimestamp() {
        return timestamp;
    }

    private ICachedPlayer sender;
    @JsonDetails
    public ICachedPlayer getSender() {
        return sender;
    }

    private String message;
    @JsonDetails
    public String getMessage() {
        return message;
    }

    private String comment;
    @JsonDetails
    public String getComment() {
        return comment;
    }

    private ticketStatus status;
    @JsonDetails
    public ticketStatus getStatus() {
        return status;
    }

    private ICachedPlayer staff;
    @JsonDetails
    public ICachedPlayer getStaff() {
        return staff;
    }

    private int notified;
    @JsonDetails
    public int getNotified() {
        return notified;
    }

    private CachedLocation location;
    @JsonDetails
    public CachedLocation getLocation() {
        return location;
    }


    public CachedTicketData(TicketData ticket) {
        super(ticket);

        this.id = ticket.getTicketID();
        this.sender = cacheService.getPlayer(ticket.getPlayerUUID()).orElse(null);
        this.timestamp = ticket.getTimestamp();
        this.message = ticket.getMessage();
        this.comment = ticket.getComment();
        this.status = ticket.getStatus();
        this.staff = cacheService.getPlayer(ticket.getPlayerUUID()).orElse(null);
        this.notified = ticket.getNotified();
        this.location = new CachedLocation(ticket.getWorld(), ticket.getX(), ticket.getY(), ticket.getZ());
    }
}
