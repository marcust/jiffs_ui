package org.thiesen.jiffs.ui.db.dao;

import java.net.UnknownHostException;

import org.thiesen.jiffs.ui.db.beans.StoryClusterDBO;
import org.thiesen.jiffs.ui.db.beans.StoryDBO;
import org.thiesen.jiffs.ui.db.converter.DateTimeTypeConverter;
import org.thiesen.troy.TroyDAO;
import org.thiesen.troy.TroyORMDAOFactory;
import org.thiesen.troy.conversion.TypeConversionMap;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.mongodb.MongoException;

public class DAOModule extends AbstractModule {

	private final String DATABASE = "jiffs";

	private final TypeConversionMap TYPE_CONVERSION_MAP = TypeConversionMap.defaultMap().with( new DateTimeTypeConverter() ); 

	@Override
	protected void configure() {
		try {
			final TroyORMDAOFactory factory = TroyORMDAOFactory.create(DATABASE, TYPE_CONVERSION_MAP );

			bind( new TypeLiteral<TroyDAO<StoryClusterDBO>>() { } ).toInstance( factory.makeDaoForClass( StoryClusterDBO.class ) );
			bind( new TypeLiteral<TroyDAO<StoryDBO>>() { } ).toInstance( factory.makeDaoForClass( StoryDBO.class ) );

		} catch (UnknownHostException e) {
			throw new RuntimeException( e );
		} catch (MongoException e) {
			throw new RuntimeException( e );
		}

	}

}
