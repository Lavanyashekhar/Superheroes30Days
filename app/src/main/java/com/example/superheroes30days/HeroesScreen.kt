package com.example.superheroes30days

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes30days.model.Hero
import com.example.superheroes30days.model.HeroesRepository

@Composable
fun SuperheroesApp() {
    Scaffold(
        topBar = { TopBar() }
    ) { padding ->
        HeroesList(
            heroes = HeroesRepository.heroes,
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "30 Days of Superheroes",
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}

@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(heroes) { hero ->
            HeroCard(hero)
        }
    }
}

@Composable
fun HeroCard(hero: Hero) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            // ✅ Bigger image with proper scaling
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // ✅ Better spacing between texts
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Day ${hero.day}",
                    style = MaterialTheme.typography.labelMedium
                )

                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}