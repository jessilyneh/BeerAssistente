package com.BeerAssistente.Beer.Assistente.Gerenciador.services;

import com.BeerAssistente.Beer.Assistente.Gerenciador.SpotifyApplication;
import com.BeerAssistente.Beer.Assistente.Gerenciador.spotfy.BeerPlaylist;
import com.BeerAssistente.Beer.Assistente.Gerenciador.spotfy.BeerTracks;
import com.neovisionaries.i18n.CountryCode;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchPlaylistsRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.neovisionaries.i18n.LocaleCode.id;

@Service
public class SpotifyServices {
    private static final String clientId = " 20af42eb59be486284cc3b560c0af308";
    private static final String clientSecret = "f2593c63f0e142bc84d640e03d0b17ed";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(clientId)
            .build();
    private static final GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(clientSecret)
//          .fields("description")
//          .market(CountryCode.SE)
            .build();

    public static void getPlaylist_Sync() {
        try {
            final Playlist playlist = getPlaylistRequest.execute();

            System.out.println("Name: " + playlist.getName());
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void getPlaylist_Async() {
        try {
            final Future<Playlist> playlistFuture = getPlaylistRequest.executeAsync();

            // ...

            final Playlist playlist = playlistFuture.get();

            System.out.println("Name: " + playlist.getName());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: " + e.getCause().getMessage());
        }
    }

    public static BeerPlaylist BeerPlaylist(String tipoCerveja){

    }
//    private static final Logger LOGGER = Logger.getLogger(SpotifyServices.class.getName());
//
//    private final CountryCode countryCode = CountryCode.BR;
//    private final int limit = 1;
//    private final int offset = 0;
//    private static SpotifyApi spotifyApiAuth;
//
//
//    public SpotifyServices() {
//        spotifyApiAuth = clientCredentialsSync();
//    }
//
//    private SpotifyApi clientCredentialsSync() {
//            final String clientId = "2017976e4e754d4b8505fd193b7a102f";
//            final String clientSecret = "35635a60b09643d89e9f84a859c18758";
//            spotifyApiAuth = new SpotifyApi.Builder()
//                    .setClientId(clientId)
//                    .setClientSecret(clientSecret)
//                    .build();
//            final ClientCredentialsRequest clientCredentialsRequest = spotifyApiAuth.clientCredentials()
//                    .build();
//            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
//            spotifyApiAuth.setAccessToken(clientCredentials.getAccessToken());
//        } catch (IOException | SpotifyWebApiException e) {
//            LOGGER.severe("Error:" + e.getMessage());
//        }
//        ret                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             urn spotifyApiAuth;
//    }
//
//    public BeerPlaylist getCervejaPlaylist(String tipoCerveja) {
//        Paging<PlaylistSimplified> playlistSimplifiedPaging = searchPlaylistSync(tipoCerveja);
//        BeerPlaylist beerPlaylist = null;
//        if (playlistSimplifiedPaging != null && playlistSimplifiedPaging.getTotal() > 0) {
//            PlaylistSimplified[] items = playlistSimplifiedPaging.getItems();
//            if (items.length > 0) {
//                beerPlaylist = getPlaylistSync(items[0].getOwner().getId(), items[0].getId());
//            }
//        }
//        return beerPlaylist;
//    }
//
//    private Paging<PlaylistSimplified> searchPlaylistSync(String query) {
//        LOGGER.info("Busque a playlist por" + query);
//
//        SearchPlaylistsRequest searchPlaylistsRequest = spotifyApiAuth.searchPlaylists(query)
//                .market(countryCode)
//                .limit(limit)
//                .offset(offset)
//                .build();
//        Paging<PlaylistSimplified> playlistSimplifiedPaging = null;
//        try {
//            playlistSimplifiedPaging = searchPlaylistsRequest.execute();
//            LOGGER.info("Total: " + playlistSimplifiedPaging.getTotal());
//        } catch (IOException | SpotifyWebApiException e) {
//            LOGGER.log(Level.SEVERE, "Erro:" + e.getMessage());
//        }
//        return playlistSimplifiedPaging;
//    }
//
//    private BeerPlaylist getPlaylistSync(String userId, String playlistId) {
//        LOGGER.log(Level.INFO, "Ver playlist de usuário: " + userId + ",id:" + playlistId);
//        try {
//            final Playlist playlist = getCervejaPlaylistRequest.execute();
//
//            System.out.println("Name: " + playlist.getName());
//        } catch (IOException | SpotifyWebApiException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        return null;
//    }
}