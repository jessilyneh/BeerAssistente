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
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.neovisionaries.i18n.LocaleCode.id;

@Service
public class SpotifyServices {
    private static final Logger LOGGER = Logger.getLogger(SpotifyServices.class.getName());

    private final CountryCode countryCode = CountryCode.BR;
    private final int limit =1;
    private final int offset =0;
    private SpotifyApi spotifyApiAuth;


    public SpotifyServices(){
        spotifyApiAuth = clientCredentialsSync();
    }

    private SpotifyApi clientCredentialsSync(){
        LOGGER.info("Pedir credenciais");
        try {
            final String clientId ="";
            final String clientSecret = "";
            spotifyApiAuth = new SpotifyApi.Builder()
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .build();
            final ClientCredentialsRequest clientCredentialsRequest =spotifyApiAuth.clientCredentials()
                    .build();
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApiAuth.setAccessToken(clientCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException e) {
            LOGGER.severe("Error:"+ e.getMessage());
        }
        return spotifyApiAuth;
    }

    public BeerPlaylist getCervejaPlaylist(String tipoCerveja) {
        LOGGER.info("Playlist para o estilo de cerveja:"+ tipoCerveja);
        Paging<PlaylistSimplified> playlistSimplifiedPaging = searchPlaylistSync(tipoCerveja);
        BeerPlaylist beerPlaylist = null;
        if (playlistSimplifiedPaging != null && playlistSimplifiedPaging.getTotal() > 0 ){
        PlaylistSimplified[] items = playlistSimplifiedPaging.getItems();
        if (items.length>0){
            beerPlaylist = getPlaylistSync(items[0].getOwner().getId(),items[0].getId());
            }
        }
        return beerPlaylist;
    }

    private Paging<PlaylistSimplified> searchPlaylistSync(String query) {
        LOGGER.info("Busque a playlist por"+ query);

        SearchPlaylistsRequest searchPlaylistsRequest = spotifyApiAuth.searchPlaylists(query)
                .market(countryCode)
                .limit(limit)
                .offset(offset)
                .build();
        Paging<PlaylistSimplified> playlistSimplifiedPaging=null;
        try {
            playlistSimplifiedPaging = searchPlaylistsRequest.execute();
            LOGGER.info("Total: "+ playlistSimplifiedPaging.getTotal());
        } catch (IOException | SpotifyWebApiException e) {
            LOGGER.log(Level.SEVERE,"Erro:"+ e.getMessage());
        }
        return playlistSimplifiedPaging;
    }

    private BeerPlaylist getPlaylistSync(String userId, String playlistId) {
        LOGGER.log(Level.INFO,"Ver playlist de usuário: "+ userId +",id:"+ playlistId);

        BeerPlaylist myPlaylist = new BeerPlaylist();
        try {

            GetPlaylistRequest getPlaylistRequest = spotifyApiAuth.getPlaylist(userId, playlistId)
                    .market(countryCode)
                    .build();
            final Playlist playlist = getPlaylistRequest.execute();
            myPlaylist.setNome(playlist.getName());
            List<BeerTracks> tracks = new ArrayList<>();
            LOGGER.info("Preencha as tracks:");
            for (PlaylistTrack item: playlist.getTracks().getItems()){

                tracks.add(new BeerTracks(item.getTrack().getName())){
                    playlist.getTracks().getItems()[0].getTrack().getArtists()[0].getName(),
                    playlist.getTracks().getItems()[0].getTrack().getArtists()[0].getHref());
                }
                myPlaylist.setBeerTracks(tracks);
            return myPlaylist;
        }
    }

    private SpotifyApi clientCredentialsSync() {
    }
}
