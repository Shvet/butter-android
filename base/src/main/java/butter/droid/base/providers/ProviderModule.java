/*
 * This file is part of Butter.
 *
 * Butter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Butter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Butter. If not, see <http://www.gnu.org/licenses/>.
 */

package butter.droid.base.providers;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import butter.droid.base.providers.media.VodoProvider;
import butter.droid.base.providers.subs.SubsProvider;
import butter.droid.base.providers.subs.YSubsProvider;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ProviderModule {

    @Provides @Singleton public SubsProvider provideSubsProvider(Context context, OkHttpClient client, Gson gson) {
        return new YSubsProvider(context, client, gson);
    }

    @Provides @Singleton public VodoProvider provideVodoProvider(OkHttpClient client, Gson gson,
            SubsProvider subsProvider) {
        return new VodoProvider(client, gson, subsProvider);
    }

}
