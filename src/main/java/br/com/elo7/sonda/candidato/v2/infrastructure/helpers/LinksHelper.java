package br.com.elo7.sonda.candidato.v2.infrastructure.helpers;

import org.springframework.hateoas.Link;

public class LinksHelper {

    public static Long extractId(String href) {
        if (href == null) return null;
        return Long.valueOf(href.replaceAll("\\D+", ""));
    }

    public static Long extractId(Link link) {
        if (link == null) return null;
        return Long.valueOf(link.getHref().replaceAll("\\D+", ""));
    }

    public static Long extractLastId(Link link) {
        if (link == null) return null;
        return Long.valueOf(link.getHref().replaceAll("^.*\\/", ""));
    }

    public static String extractIdString(Link link) {
        if (link == null) return null;
        return link.getHref().replaceAll("^.*\\/", "");
    }
}
